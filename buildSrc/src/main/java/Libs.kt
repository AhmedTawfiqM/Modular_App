object Libs {

    val androidLibs = AndroidLibs
    val materialDesignLibs = MaterialDesignLibs

    object AndroidLibs {
        const val core = "androidx.core:core-ktx:${Versions.appCompat}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    }

    object MaterialDesignLibs {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Versions {

        const val core = "1.6.0"
        const val appCompat = "1.3.1"
        const val material = "1.4.0"
        const val constraintLayout = "2.1.0"

    }
}

