plugins {
    alias(libs.plugins.kotlinJvm)
}

dependencies {
    compileOnly(libs.android.lint.api)
    compileOnly(libs.android.lint.checks)

    testImplementation(libs.android.lint.tests)
    testImplementation(libs.junit)
}

tasks.jar {
    manifest {
        attributes("Lint-Registry-v2" to "com.eraqi.social_media_demo_app.lint.SampleIssueRegistry")
    }
}
