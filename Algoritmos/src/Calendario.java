import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendario {

    private static final String[] gifts = {
            "Regalo del día 1", "Regalo del día 2", "Regalo del día 3", "Regalo del día 4",
            "Regalo del día 5", "Regalo del día 6", "Regalo del día 7", "Regalo del día 8",
            "Regalo del día 9", "Regalo del día 10", "Regalo del día 11", "Regalo del día 12",
            "Regalo del día 13", "Regalo del día 14", "Regalo del día 15", "Regalo del día 16",
            "Regalo del día 17", "Regalo del día 18", "Regalo del día 19", "Regalo del día 20",
            "Regalo del día 21", "Regalo del día 22", "Regalo del día 23", "Regalo del día 24"
    };

    public static String checkAdventCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.DECEMBER, 1, 0, 0, 0);
        Date startDate = calendar.getTime();

        calendar.set(2022, Calendar.DECEMBER, 25, 0, 0, 0);
        Date endDate = calendar.getTime();

        if (date.before(startDate)) {
            long diff = startDate.getTime() - date.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            return "Faltan " + days + " días para que comience el calendario.";
        } else if (date.after(endDate)) {
            long diff = date.getTime() - endDate.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            return "Han pasado " + days + " días desde que finalizó el calendario.";
        } else {
            calendar.setTime(date);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            String gift = gifts[dayOfMonth - 1];

            long diff = endDate.getTime() - date.getTime();
            long hours = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
            long minutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS) % 60;
            long seconds = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS) % 60;

            return "Regalo del día " + dayOfMonth + ": " + gift +
                    ". Quedan " + hours + " horas, " + minutes + " minutos y " + seconds + " segundos para que finalice el sorteo.";
        }
    }

    public static void main(String[] args) {
        Calendar testDate = Calendar.getInstance();
        testDate.set(2022, Calendar.DECEMBER, 15, 12, 0, 0); // 15 de diciembre de 2022
        System.out.println(checkAdventCalendar(testDate.getTime()));
        testDate.set(2022, Calendar.NOVEMBER, 30, 12, 0, 0); // 30 de noviembre de 2022
        System.out.println(checkAdventCalendar(testDate.getTime()));
        testDate.set(2022, Calendar.DECEMBER, 26, 12, 0, 0); // 26 de diciembre de 2022
        System.out.println(checkAdventCalendar(testDate.getTime()));
    }
}
