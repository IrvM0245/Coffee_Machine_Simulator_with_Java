class Army {

    public static void createArmy() {
        // Create all objects here
        //UNITS
        Unit unit1 = new Unit("unit 1");
        Unit unit2 = new Unit("unit 2");
        Unit unit3 = new Unit("unit 3");
        Unit unit4 = new Unit("unit 4");
        Unit unit5 = new Unit("unit 5");
        //KNIGHT
        Knight knight1 = new Knight("knight 1");
        Knight knight2 = new Knight("knight 2");
        Knight knight3 = new Knight("knight 3");
        //GENERAL
        General general1 = new General("general 1");
        //DOCTOR
        Doctor doctor1 = new Doctor("doctor 1");
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

}