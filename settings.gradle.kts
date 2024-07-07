pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "Cinema"
include(":app")

include(":design:resources")

include(":component:arch")
include(":component:token")
include(":component:network")

include(":util:formatting")
include(":util:di")

include(":shared:loan")
include(":shared:film")

include(":feature:history")
include(":feature:poster")