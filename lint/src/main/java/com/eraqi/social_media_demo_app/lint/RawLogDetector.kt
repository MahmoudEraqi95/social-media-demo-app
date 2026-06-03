package com.eraqi.social_media_demo_app.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class RawLogDetector : Detector(), SourceCodeScanner {

    override fun getApplicableMethodNames(): List<String> = listOf("v", "d", "i", "w", "e", "wtf")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (context.evaluator.isMemberInClass(method, "android.util.Log")) {
            context.report(
                ISSUE_RAW_LOG,
                node,
                context.getLocation(node),
                "Use a centralized logger instead of android.util.Log"
            )
        }
    }

    companion object {
        val ISSUE_RAW_LOG = Issue.create(
            id = "RawLogUsage",
            briefDescription = "Direct use of android.util.Log is discouraged",
            explanation = "Direct use of `android.util.Log` is discouraged. Use a centralized logging utility to manage log levels and formatting consistently.",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            implementation = Implementation(RawLogDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}
