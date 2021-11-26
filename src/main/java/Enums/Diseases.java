package Enums;

public enum Diseases {
    TRACHEITIS("Zapalenie tchawicy"),
    QUINSY ("Angina"),
    GASTRITIS ("zapalenie żołądka "),
    ALLERGIC_REACTION("reakcja alergiczna "),
    CATARRHAL_PNEUMONIA("nieżytowe zapalenie płuc"),
    MOUTH_INFECTION("zapalenie jamy ustnej"),
    JAUNDICE("żółtaczka"),
    GLOMERULONEPHRITIS("kłębuszkowe zapalenie nerek"),
    UROLITHIASIS("kamica układu moczowego"),
    SUNSTROKE("udar słoneczny"),
    RABIES("wścieklizna"),
    BOTULISM("botulism"),
    SALMONELLOSIS("salmonelloza"),
    CEREBRAL_ISCHEMIA("niedokrwienie mózgu"),
    OTITIS("zapalenie ucha");

    private final String name;

    private Diseases(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}