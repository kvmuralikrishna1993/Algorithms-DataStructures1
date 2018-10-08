import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Comparator;
/**
 * { Solution class }
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_main }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) throws ParseException{
		Insertion isort  = new Insertion();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String constant = "01-01-2000";
		Date date1 = sdf.parse(constant);
		Scanner sc = new Scanner(System.in);
		int tstudents = Integer.parseInt(sc.nextLine());
		int vacancies = Integer.parseInt(sc.nextLine());
		int ocVacancies = Integer.parseInt(sc.nextLine());
		int bcVacancies = Integer.parseInt(sc.nextLine());
		int scVacancies = Integer.parseInt(sc.nextLine());
		int stVacancies = Integer.parseInt(sc.nextLine());
		Reservation[] rev = new Reservation[tstudents];
		for (int i = 0; i < tstudents; i++) {
			String information = sc.nextLine();
			String tokens[] = information.split(",");
			Date date2 = sdf.parse(tokens[1]);
			long diff = date1.getTime() - date2.getTime();
			long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			//System.out.println(days + tokens[0]);
			rev[i] = new Reservation(tokens[0], days, tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
		}
		isort.sort(rev);
		isort.show(rev);
		//System.out.println();
		isort.seats(rev,ocVacancies,bcVacancies,scVacancies,stVacancies,tstudents);
	}
}