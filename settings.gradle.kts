plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "same_back_for_same_app"
include(":client")
include(":shared")
