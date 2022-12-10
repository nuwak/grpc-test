
rootProject.name = "grps-test"
include("server")
include("proto")
include("stub-lite")
include("stub")
include("client")
include("native-client")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
