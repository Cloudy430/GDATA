package gr.fresh.trash.string;

public abstract class Constants {
	
	/** All special Chars */
	public static final String SPECIALCHARS = "#@$%^&*?!";

	/** All digits. */
	public static final String NUMBERS = "0123456789";

	/** The alphabet-chars in lower case. */
	public static final String LOWCASECHARS = "abcdefghijklmnopqrstuvwxyz";

	/** The alphabet-chars in upper case. */
	public static final String UPPERCASECHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/** Lowercase chars and numbers. */
	public static final String LCCHARSWN = LOWCASECHARS + NUMBERS;

	/** Uppercase chars and numbers. */
	public static final String UCCHARSWN = UPPERCASECHARS + NUMBERS;

	/** Lowercase chars, numbers and special chars. */
	public static final String LCCHARSWNASC = LOWCASECHARS + NUMBERS
			+ SPECIALCHARS;

	/** Lowercase chars, numbers and special chars. */
	public static final String UCCHARSWNASC = UPPERCASECHARS + NUMBERS
			+ SPECIALCHARS;

}
