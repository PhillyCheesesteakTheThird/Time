public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(){
        this.hours = 24;
        this.minutes = 0;
        this.seconds = 0;
    }
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    public void fromString(String time) {

        this.hours = Integer.parseInt(time.substring(0, time.indexOf(":")));
        this.minutes = Integer.parseInt(time.substring(3,5));
        this.seconds = Integer.parseInt(time.substring(6));
    }

    public void increment(int amountInSeconds){
        int hours = this.hours + amountInSeconds / 3600;
        int minutes = this.minutes + (amountInSeconds % 3600) / 60;
        int seconds = this.seconds + (amountInSeconds % 3600) % 60;
        this.hours = hours;
        if (minutes<60) {
            this.minutes = minutes;
        }else{
            this.minutes = minutes % 60;
            this.hours = hours + (minutes/60);
        }
        if (seconds<60) {
            this.seconds = seconds;
        }else{
            this.seconds = seconds % 60;
            this.minutes = minutes + (seconds/60);
        }
    }

    public void print(boolean militaryTime){
        this.hours = this.hours % 24;
        if (!militaryTime) {
            if (this.hours > 12) {
                System.out.print((timeConstructor(this.hours % 12)) + ":");
                System.out.print(timeConstructor(this.minutes) + ":");
                System.out.print(timeConstructor(this.seconds) + " PM\n");
            }else{
                System.out.print((timeConstructor(this.hours)) + ":");
                System.out.print(timeConstructor(this.minutes) + ":");
                System.out.print(timeConstructor(this.seconds) + " AM\n");

            }
        }
        else {
            if (this.hours > 12) {
            System.out.print((timeConstructor(this.hours)) + ":");
            System.out.print(timeConstructor(this.minutes) + ":");
            System.out.print(timeConstructor(this.seconds) + " \n");
            }else {
                System.out.print(timeConstructor(this.hours) + ":");
                System.out.print(timeConstructor(this.minutes) + ":");
                System.out.print(timeConstructor(this.seconds) + " \n");
            }
        }
    }

    private String timeConstructor(int numbers){
        if (numbers>10) {
            return Integer.toString(numbers);
        }else {
            return ("0"+numbers);
        }
    }
}
