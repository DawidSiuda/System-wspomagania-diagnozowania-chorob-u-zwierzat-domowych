package Enums;

public enum Symptoms {
    LACK_OF_APPETITE ("brak apetytu"),
    FEVER ("gorączka"),
    DEPRESSION("osowiałość"),
    VOMITING("wymioty"),
    COUGH("kaszel"),
    ENLARGED_LYMPH_NODES("powiększone węzły chłonne "),
    HIGH_NUMBER_OF_WHITE_BLOOD_CELLS("podwyższona ilość białych krwinek"),
    DIARRHEA("biegunka"),
    ABDOMINAL_PAIN("ból brzucha"),
    THICKENING_OF_THE_STOMACH_WALLS("pogrubienie ścian żołądka"), //10
    TIGHT_ABDOMINAL_WALL("napięte powłoki brzuszne"),
    SKIN_SYMPTOMS("objawy skórne"),
    RAPID_BREATHING("przyśpieszony oddech"),
    INCREASED_HEART_RATE("przyśpieszone tętno"),
    TISSUE_SWELLING("obrzęk tkanek"),
    HIGHER_TEMPERATURE("podwyższona temperatura"),
    DYSPNOEA("duszność"),
    REDNESS_OF_THE_ORAL_MUCOSA("zaczerwienienie błon śluzowych jamy ustnej"),
    PURULENT_DISCHARGE_FROM_THE_NOSE("ropny wypływ z nosa"),        //20
    WEAKENED_VESICULAR_MURMURS("osłabione szmery pęcherzykowe"),
    ACUTE_ALVEOLAR_MURMURS("zaostrzone szmery pęcherzykowe"),
    CHEWING_IMPAIRMENT("upośledzenie żucia"),
    REDUCED_WATER_CONSUMPTION("obniżone spożycie wody"),
    SALIVATION("ślinotok"),
    DIFFICULTY_SWALLOWING("trudności w przełykaniu"),
    DAMAGE_TO_THE_MUCOUS_MEMBRANES("uszkodzenie błony śluzowych"),
    YELLOWING_OF_THE_SKIN("zazółcenie skóry"),
    ANEMIA("niedokrwistość"),       // 30
    BLOOD_IN_THE_STOOL("krew w kale"),
    DROP_IN_BODY_TEMPERATURE("obniżona temperatura"),
    ELEVATED_BILIRUBIN_LEVEL("podwyższony poziom bilirubiny"),
    PALLOR_OF_THE_MUCOUS_MEMBRANES("bladość błon śluzowych"),
    APATHY("apatia"),
    INCREASED_WATER_CONSUMPTION("wzmożone spożycie wody"),
    RELUCTANCE_TO_MOVE("niechęć do poruszania się"),
    HIGH_BLOOD_PRESSURE("podwyższone ciśnienie"),
    CLOUDY_URINE("mętny mocz"),
    BLOOD_IN_URINE("krew w moczu"),
    ELEVATED_BLOOD_UREA_LEVELS("podwyższony poziom mocznika we krwi"), // 40
    INCREASE_IN_BLOOD_CREATININE_LEVELS("wzrost stężenia kreatyniny we krwi"),
    PAIN_IN_THE_KIDNEY_AREA("ból w okolicach nerek"),
    POLLAKIURIA("częstomocz "),
    PRESENCE_OF_ERYTHROCYTES_AND_LEUKOCYTES_IN_THE_URINE("obecność erytrocytów i leukocytów w moczu"),
    DECREASE_IN_THE_AMOUNT_OF_URINE_PASSED("spadek ilości oddawanego moczu"),
    SEIZURES("drgawki"),
    AGGRESSION("agresja"),
    DISTORTED_APPETITE("spaczony apetyt"),
    DILATED_PUPILS("rozszerzone źrenice"),
    OVERREACTION_TO_STIMULI("nadmierna reakcja na bodźce"),         //50
    COMA("śpiączka"),
    RESPIRATORY_SYSTEM_PARALYSIS("porażenie układu oddechowego"),
    MANDIBLE_DROOP("opadnięcie żuchwy"),
    PROGRESSIVE_MUSCLE_WEAKNESS("postępujące osłabienie mięśni"),
    MANDIBULAR_CONVULSIONS("drgawki żuchwy"),
    NO_SWALLOWING_REFLEX("brak odruchu przełykania"),
    DEHYDRATION("odwodnienie"),
    SHAKY_GAIT("chwiejny chód"),
    INCOHERENCE_OF_MOVEMENTS("niezborność ruchów "),
    HEAD_SHAKING("potrząsanie głową "),         // 60
    TILTING_THE_HEAD_TO_ONE_SIDE("pochylenie głowy na jedną strone"),
    SCRATCHING_THE_EAR("drapanie ucha"),
    BAD_SMELL_FROM_THE_EAR("nieprzyjemny zapach z ucha"),
    SORENESS_WHEN_TOUCHING_THE_EAR("bolesność przy dotykaniu ucha ");

    private final String name;

    private Symptoms(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
