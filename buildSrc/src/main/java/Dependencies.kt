/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Deps {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.compose}" }
    val composePreView by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val lifeCycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val testJunit by lazy { "junit:junit:${Versions.jUnit}" }
    val androidTestJunit by lazy { "androidx.test.ext:junit:${Versions.androidTest}" }
    val espressoTest by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoTest}" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val debugCompose by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }

}

