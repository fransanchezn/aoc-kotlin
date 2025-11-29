import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun <T> readInput(clazz: Class<T>, name: String): List<String> {
    val packageName = clazz.`package`?.name?.replace('.', '/')
        ?: throw IllegalArgumentException("Package name not found for class ${clazz.name}")

    return Path("src/${packageName}/$name.txt").readText().trim().lines()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
