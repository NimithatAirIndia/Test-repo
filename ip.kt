/**
 * Validates an IP address. Returns true if the given string is a valid IP address, false otherwise.
 *
 * @param ipAddress The IP address to validate.
 * @return True if the given string is a valid IP address, false otherwise.
 */
fun validateIPAddress(ipAddress: String): Boolean {
    val parts = ipAddress.split(".")
    if (parts.size != 4) {
        return false
    }

    for (part in parts) {
        try {
            val value = part.toInt()
            if (value < 0 || value > 255) {
                return false
            }
            if (value.toString() != part) {
                return false
            }
        } catch (e: NumberFormatException) {
            return false
        }
    }

    return true
}
