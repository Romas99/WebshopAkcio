package hu.mak.Training360.WebshopAkcio;

public enum Akcio {

    A_23("2=3 akció","D01", "DB",3, 0L), A_MEGA("Megapack akció","M01","MEGA",12, 6000L);

    private final String akcioNev;
    private final String akcioKod;
    private final String akcioTipus;
    private final int akcioDb;
    private final Long akcioFixKedv;

    private Akcio(String akcioNev, String akcioKod, String akcioTipus, int akcioDb, Long akcioFixKedv){
        this.akcioNev = akcioNev;
        this.akcioKod = akcioKod;
        this.akcioTipus = akcioTipus;
        this.akcioDb = akcioDb;
        this.akcioFixKedv = akcioFixKedv;

        if (Akcio.Dummy.maxIndex == null || Akcio.Dummy.maxIndex < this.ordinal()) {
            Akcio.Dummy.maxIndex = this.ordinal();
        }
    }

    public String getAkcioNev() {
        return akcioNev;
    }

    public String getAkcioKod() {
        return akcioKod;
    }

    public String getAkcioTipus() {
        return akcioTipus;
    }

    public int getAkcioDb() {
        return akcioDb;
    }

    public Long getAkcioFixKedv() {
        return akcioFixKedv;
    }

    @Override
    public String toString() {
        return "Akcio{" +
                "akcioNev='" + akcioNev + '\'' +
                ", akcioKod='" + akcioKod + '\'' +
                ", akcioTipus='" + akcioTipus + '\'' +
                ", akcioDb=" + akcioDb +
                ", akcioFixKedv=" + akcioFixKedv +
                '}';
    }

    // This seems to be needed because you can't access static fields in enum constructors
    private static class Dummy {
        private static Integer maxIndex = null;
    }

    public static int getMaxIndex() {
        return Akcio.Dummy.maxIndex;
    }
}