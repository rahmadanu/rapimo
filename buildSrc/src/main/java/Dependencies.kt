object Plugins {

}

object Versions {
    const val composeCompiler = "1.4.0"
}

object Libs {

    // Compose
    private const val verComposeBom = "2023.04.01"
    private const val verNavigation = "2.5.3"
    private const val verComposeViewModel = "2.5.1"
    private const val verComposeActivity = "1.6.1"
    private const val verHiltCompose = "1.0.0"
    private const val verRoom = "2.5.0"

    const val composeBom = "androidx.compose:compose-bom:$verComposeBom"
    const val composeNavigation = "androidx.navigation:navigation-compose:$verNavigation"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeMaterial3WindowSizeClass = "androidx.compose.material3:material3-window-size-class"
    const val composeFoundation = "androidx.compose.foundation:foundation"
    const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeRuntime = "androidx.compose.runtime:runtime"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$verComposeViewModel"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeActivity = "androidx.activity:activity-compose:$verComposeActivity"
    const val composeHilt = "androidx.hilt:hilt-navigation-compose:$verHiltCompose"
    const val roomRuntime = "androidx.room:room-runtime:$verRoom"
    const val roomCompiler = "androidx.room:room-compiler:$verRoom"
    const val roomKtx = "androidx.room:room-ktx:$verRoom"

    /*
    // UI Tests
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'

    // Optional - Included automatically by material, only add when you need
    // the icons but not the material library (e.g. when using Material3 or a
    // custom design system based on Foundation)
    implementation 'androidx.compose.material:material-icons-core'
    // Optional - Add full set of material icons
    implementation 'androidx.compose.material:material-icons-extended'*/
}