package com.eraqi.social_media_demo_app.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.ULiteralExpression

class ComposeHardcodedStringDetector : Detector(), SourceCodeScanner {

    override fun getApplicableMethodNames(): List<String> = listOf("Text")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        val argument = node.valueArguments.firstOrNull()
        if (argument is ULiteralExpression && argument.value is String) {
             context.report(
                ISSUE_HARDCODED_COMPOSE_STRING,
                node,
                context.getLocation(node),
                "Hardcoded string in Compose Text. Use string resources instead."
            )
        }
    }

    companion object {
        val ISSUE_HARDCODED_COMPOSE_STRING = Issue.create(
            id = "HardcodedComposeString",
            briefDescription = "Hardcoded string in Compose",
            explanation = "Using hardcoded strings in UI components makes localization difficult. Use string resources instead.",
            category = Category.I18N,
            priority = 5,
            severity = Severity.WARNING,
            implementation = Implementation(ComposeHardcodedStringDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}
