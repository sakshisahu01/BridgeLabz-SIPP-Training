class SpringSeason
{
    public static boolean isSpringSeason(int month, int day)
	{
        if ((month == 3 && day >= 20 && day <= 31) ||(month == 4 && day >= 1 && day <= 30) ||(month == 5 && day >= 1 && day <= 31) ||(month == 6 && day >= 1 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        boolean result = isSpringSeason(month, day);

        if (result) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
