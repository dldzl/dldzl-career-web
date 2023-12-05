interface Platform {
    val name: String
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect fun getPlatform(): Platform