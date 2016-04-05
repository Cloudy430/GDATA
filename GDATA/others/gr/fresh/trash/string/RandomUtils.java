package gr.fresh.trash.string;

/**
 * @author Asterios.Raptis@web.de
 */
public class RandomUtils {

	/**
	 * The Method randomInt(int) gets an int to the spezified range. For
	 * example: if you put bereich to 10 the random int is between 0-9.
	 * 
	 * @param bereich
	 *            The Range.
	 * @return an int not greater then the range.
	 */
	public static int randomInt(int bereich) {
		return ((int) (Math.random() * bereich));
	}
	
	/**
	 * Returns a random int between the range from start and end.
	 * @param start The int from where the range starts.
	 * @param end The int from where the range ends.
	 * @return A random int between the range from start and end.
	 */
	public static int getRandomIntBetween(int start, int end) {
		return (start + randomInt(end - start));
	}

	/**
	 * Returns a random boolean.
	 * @return The random boolean.
	 */
	public static boolean randomBoolean() {
		return (randomInt(2) == 0) ? false : true;
	}

	/**
	 * The Method randomString(String []) a random String from the Array For
	 * example: The Stringarray test as argument. Possible values: "blab",
	 * "flih", "klap", "teta", "brut", "gzft", "ccp". Possible selection can be
	 * one value from the Stringarray like "blab" or "klap".
	 * 
	 * @param array
	 *            The array with the String to be selected.
	 * @return The selected String from the array.
	 */
	public static String randomString(String[] array) {
		return (array[randomInt(array.length)]);
	}

	/**
	 * The Method randomChar(String) selects a random char from the given
	 * String.
	 * 
	 * @param string
	 *            The String from who to select the char.
	 * @return The selected char.
	 */
	public static char randomChar(String string) {
		return (string.charAt(randomInt(string.length())));
	}

	/**
	 * The Method randomString(String, int) makes an random String from the
	 * given String and to the spezified length. This can be used to produce
	 * passwords.
	 * 
	 * @param chars
	 *            The String to get the random chars.
	 * @param laenge
	 *            The length from the random String.
	 * @return The produced random String.
	 */
	public static String randomString(String chars, int laenge) {
		StringBuffer ergebnis = new StringBuffer();
		for (int i = 0; i < laenge; i++) {
			ergebnis.append(randomChar(chars));
		}
		return (ergebnis.toString());
	}

	/**
	 * The Method getRandomPassword(int) produces a random password.
	 * 
	 * @param laenge
	 *            The length from the password.
	 * @return The password.
	 */
	public static String getRandomPassword(int laenge) {
		String password = randomString(Constants.LOWCASECHARS, laenge);
		return password;
	}

	/**
	 * The Method getRandomNumber(int) produces a random Number to the specified
	 * length.
	 * 
	 * @param laenge
	 *            The length from the random number.
	 * @return The random number as String.
	 */
	public static String getRandomNumber(int laenge) {
		String randomNumber = randomString(Constants.NUMBERS, laenge);
		return randomNumber;
	}

	/**
	 * The Method getRandomFloat(int,int) gets an random float.
	 * 
	 * @param nachkomma
	 *            How many decimal places after the comma.
	 * @param vorkomma
	 *            How many decimal places before the comma.
	 * @return The produced float.
	 */
	public static float getRandomFloat(int nachkomma, int vorkomma) {
		String nachkommastellen = getRandomNumber(nachkomma);
		String vorkommastellen = getRandomNumber(vorkomma);
		String result = nachkommastellen + "." + vorkommastellen;
		return Float.parseFloat(result);
	}

	/**
	 * The Method getRandomEmail() gets a random email-address.
	 * 
	 * @return The random email-address.
	 */
	public static String getRandomEmail() {
		StringBuffer email = new StringBuffer();
		String emailprefix = randomString(Constants.LCCHARSWN, randomInt(20) + 1);
		String domain = randomString(Constants.LOWCASECHARS, randomInt(12) + 1);
		String topDomain = randomString(Constants.LOWCASECHARS, 2);
		email.append(emailprefix);
		email.append("@");
		email.append(domain);
		email.append(".");
		email.append(topDomain);
		return email.toString();
	}

	public static String getRandomWebsite() {
		String randomWebsite = null;
		StringBuffer website = new StringBuffer();
		String websitePrefix = "http://www";
		String domain = randomString(Constants.LOWCASECHARS, randomInt(12) + 1);
		String topDomain = randomString(Constants.LOWCASECHARS, 2);
		website.append(websitePrefix);
		website.append(".");
		website.append(domain);
		website.append(".");
		website.append(topDomain);
		randomWebsite = website.toString();
		return randomWebsite;
	}

	public static String getInfomailFromWebsite(String url) {
		String infomail = "";
		int startIndex = url.indexOf("www.");
		StringBuffer email = new StringBuffer();
		if (0 < startIndex) {
			String emailprefix = "info";
			email.append(emailprefix);
			email.append("@");
			email.append(url.substring(startIndex + 4, url.length()));
		} else {
			startIndex = url.indexOf("//");
			if (0 < startIndex) {
				String emailprefix = "info";
				email.append(emailprefix);
				email.append("@");
				email.append(url.substring(startIndex + 2, url.length()));
			} else {
				throw new IllegalArgumentException(url);
			}
		}
		infomail = email.toString();
		return infomail;
	}

	/**
	 * Returns a random hellenic firstname. The encoding is the charset
	 * ISO-8859-7.
	 * 
	 * @return The random hellenic firstname.
	 */
	public static String getRandomHellenicFirstName() {
		String randomFirstname = null;
		int randomIndex = RandomUtils
				.randomInt(HellenicAddressConst.MAIL_FIRSTNAME.length);
		randomFirstname = HellenicAddressConst.MAIL_FIRSTNAME[randomIndex];
		return randomFirstname;
	}

	/**
	 * Returns a random hellenic lastname. The encoding is the charset
	 * ISO-8859-7.
	 * 
	 * @return The random hellenic lastname.
	 */
	public static String getRandomHellenicLastName() {
		String randomFirstname = null;
		int randomIndex = RandomUtils
				.randomInt(HellenicAddressConst.MAIL_LASTNAME.length);
		randomFirstname = HellenicAddressConst.MAIL_LASTNAME[randomIndex];
		return randomFirstname;
	}

	/**
	 * Returns a random hellenic birthname. The encoding is the charset
	 * ISO-8859-7.
	 * 
	 * @return The random hellenic birthname.
	 */
	public static String getRandomHellenicBirthName(String lastname) {
		String randomFirstname = null;
		boolean equal = true;
		while (equal) {
			int randomIndex = RandomUtils
					.randomInt(HellenicAddressConst.MAIL_LASTNAME.length);
			randomFirstname = HellenicAddressConst.MAIL_LASTNAME[randomIndex];
			if (!lastname.equals(randomFirstname)) {
				equal = false;
				break;
			}

		}
		return randomFirstname;
	}

	public static String getRandomHellenicStreet() {
		String randomStreet = null;
		int randomIndex = RandomUtils
				.randomInt(HellenicAddressConst.STREETS.length);
		randomStreet = HellenicAddressConst.STREETS[randomIndex];
		return randomStreet;
	}

	public static String[] getRandomHellenicZipAndCity() {
		String[] randomZipAndCity = new String[2];
		int randomIndex = RandomUtils
				.randomInt(HellenicAddressConst.CITIES.length);
		randomZipAndCity[0] = HellenicAddressConst.CITIES[randomIndex][0];
		randomZipAndCity[1] = HellenicAddressConst.CITIES[randomIndex][1];
		return randomZipAndCity;
	}

	public static String getRandomPhonenumber() {
		StringBuffer randomPhonenumber = new StringBuffer();
		randomPhonenumber.append("0");
		randomPhonenumber.append(getRandomNumber(4));
		randomPhonenumber.append("/");
		randomPhonenumber.append(getRandomNumber(7));
		return randomPhonenumber.toString();
	}

	public static String getRandomFaxnumber(String phonenumber) {
		String randomFax = phonenumber.substring(0, phonenumber.length() - 2);
		String phoneExtension = phonenumber.substring(phonenumber.length() - 2,
				phonenumber.length());
		Integer phEx = new Integer(phoneExtension);
		int pe = phEx.intValue() + 1;
		randomFax.concat("" + pe);
		return randomFax;
	}

	public static String getRandomMobilnumber() {
		StringBuffer randomPhonenumber = new StringBuffer();
		randomPhonenumber.append("0");
		randomPhonenumber.append(getRandomNumber(3));
		randomPhonenumber.append("/");
		randomPhonenumber.append(getRandomNumber(7));
		return randomPhonenumber.toString();
	}

	public static String getRandomHellenicCompany() {
		int randomIndex = RandomUtils
				.randomInt(HellenicAddressConst.COMPANYNAMES.length);
		StringBuffer randomCompany = new StringBuffer();
		randomCompany.append(getRandomHellenicLastName() + " ");
		randomCompany.append(HellenicAddressConst.COMPANYNAMES[randomIndex]);

		return randomCompany.toString();
	}

	public static String getRandomHellenicContactPerson() {
		StringBuffer randomContactPerson = new StringBuffer();
		randomContactPerson.append(getRandomHellenicFirstName() + " "
				+ getRandomHellenicLastName());
		return randomContactPerson.toString();
	}

}
