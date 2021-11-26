package com.example.demo;

import Enums.Diseases;
import Enums.QuestionTypes;
import Enums.Symptoms;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.*;

public class Controller {

    Random rand = new Random();
    private Vector<Triplet<String, QuestionTypes, Symptoms>> questionsVector = new Vector<>(0);
    private Map<Diseases, Vector<Symptoms>> diseasesMap = new HashMap<>();
    private Vector<Symptoms> occurredSymptomsVector = new Vector<>(0);
    private Integer currentQuestionId;
    private RandWithoutDuplicates randWithoutDuplicates;
    private Map<Diseases, Integer> diseasesStatisticMap = new HashMap<>();

    @FXML
    public Label labelQuestionText;
    @FXML
    public StackedBarChart diseasesChart;
    @FXML
    public CategoryAxis xAxis;
    @FXML
    public NumberAxis yAxis;
    @FXML
    public Button yesButton;
    @FXML
    public Button noButton;

    private void fillQuestionsVector()
    {
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy wystąpił brak apetytu?", QuestionTypes.YESNO, Symptoms.LACK_OF_APPETITE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy wystąpiła gorączka?", QuestionTypes.YESNO, Symptoms.FEVER));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierze jest osowiałe?", QuestionTypes.YESNO, Symptoms.DEPRESSION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występują wymioty?", QuestionTypes.YESNO, Symptoms.VOMITING));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy wystęuje kaszel?", QuestionTypes.YESNO, Symptoms.COUGH));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy poziom białych krwinek jest podwyższony?", QuestionTypes.YESNO, Symptoms.HIGH_NUMBER_OF_WHITE_BLOOD_CELLS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy migdałki są powiększone?", QuestionTypes.YESNO, Symptoms.ENLARGED_LYMPH_NODES));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje biegunka?", QuestionTypes.YESNO, Symptoms.DIARRHEA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy wystęuje ból brzucha?", QuestionTypes.YESNO, Symptoms.THICKENING_OF_THE_STOMACH_WALLS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy powłoki brzuszne są napięte?", QuestionTypes.YESNO, Symptoms.TIGHT_ABDOMINAL_WALL));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występują objawy skórne?", QuestionTypes.YESNO, Symptoms.SKIN_SYMPTOMS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy oddech zwierzęcia jest przyuśpieszony?", QuestionTypes.YESNO, Symptoms.RAPID_BREATHING));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy tętno jest przyśpieszone?", QuestionTypes.YESNO, Symptoms.INCREASED_HEART_RATE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje obrzęk partii ciała?", QuestionTypes.YESNO, Symptoms.TISSUE_SWELLING));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy temperatura ciała jest podwyższona?", QuestionTypes.YESNO, Symptoms.HIGHER_TEMPERATURE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występują duszności?", QuestionTypes.YESNO, Symptoms.DYSPNOEA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy błony śluzowe jamy ustnej są zaczerwienione?", QuestionTypes.YESNO, Symptoms.REDNESS_OF_THE_ORAL_MUCOSA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje ropny wypływ z nosa?", QuestionTypes.YESNO, Symptoms.PURULENT_DISCHARGE_FROM_THE_NOSE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy szmery pęcherzykowe płuc są osłabione?", QuestionTypes.YESNO, Symptoms.WEAKENED_VESICULAR_MURMURS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy szmery pęcherzykowe płuc są zaostrzone?", QuestionTypes.YESNO, Symptoms.ACUTE_ALVEOLAR_MURMURS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma problemy z przeżuwaniem?", QuestionTypes.YESNO, Symptoms.CHEWING_IMPAIRMENT));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę spożywa mniej wody niż zazwyczaj?", QuestionTypes.YESNO, Symptoms.REDUCED_WATER_CONSUMPTION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje ślinotok?", QuestionTypes.YESNO, Symptoms.SALIVATION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma trudności w przełykaniu?", QuestionTypes.YESNO, Symptoms.DIFFICULTY_SWALLOWING));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy błony śluzowe jamy ustnej są uszkodzone?", QuestionTypes.YESNO, Symptoms.DAMAGE_TO_THE_MUCOUS_MEMBRANES));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy skóra jest żółta?", QuestionTypes.YESNO, Symptoms.YELLOWING_OF_THE_SKIN));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje niedokrwistość?", QuestionTypes.YESNO, Symptoms.ANEMIA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy w kale pojawia się krew?", QuestionTypes.YESNO, Symptoms.BLOOD_IN_THE_STOOL));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy temperatura ciała jest obniżona?", QuestionTypes.YESNO, Symptoms.DROP_IN_BODY_TEMPERATURE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy poziom bilirubiny jest podwyższony?", QuestionTypes.YESNO, Symptoms.ELEVATED_BILIRUBIN_LEVEL));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy błony śluzowe jamy ustnej są blade?", QuestionTypes.YESNO, Symptoms.PALLOR_OF_THE_MUCOUS_MEMBRANES));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy u zwierzęcia występuje apatia?", QuestionTypes.YESNO, Symptoms.APATHY));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę piję więcej wody niż zazwyczaj?", QuestionTypes.YESNO, Symptoms.INCREASED_WATER_CONSUMPTION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę  wykazuje niechęć do poruszania się?", QuestionTypes.YESNO, Symptoms.RELUCTANCE_TO_MOVE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy ciśnienie krwi jest podwyższone?", QuestionTypes.YESNO, Symptoms.HIGH_BLOOD_PRESSURE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy mocz jest mętny?", QuestionTypes.YESNO, Symptoms.CLOUDY_URINE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy w moczu występuje krew?", QuestionTypes.YESNO, Symptoms.BLOOD_IN_URINE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy w krwi jest podwyższony poziom mocznika?", QuestionTypes.YESNO, Symptoms.ELEVATED_BLOOD_UREA_LEVELS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy poziom kreatyniny we krwi jest podwyższony?", QuestionTypes.YESNO, Symptoms.INCREASE_IN_BLOOD_CREATININE_LEVELS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje ból w okolicach nerek?", QuestionTypes.YESNO, Symptoms.PAIN_IN_THE_KIDNEY_AREA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje częstomocz?", QuestionTypes.YESNO, Symptoms.POLLAKIURIA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy w moczu występują erytrocyty lub leukocytów?", QuestionTypes.YESNO, Symptoms.PRESENCE_OF_ERYTHROCYTES_AND_LEUKOCYTES_IN_THE_URINE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę oddaję mniej moczu niż zazwyczaj?", QuestionTypes.YESNO, Symptoms.DECREASE_IN_THE_AMOUNT_OF_URINE_PASSED));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy u zwierzęcia występują drgawki?", QuestionTypes.YESNO, Symptoms.SEIZURES));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zweirzę jest agresywne?", QuestionTypes.YESNO, Symptoms.AGGRESSION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę zjada dziwne, wręcz niejadalne rzeczy?", QuestionTypes.YESNO, Symptoms.DISTORTED_APPETITE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma rozszerzone źrenice?", QuestionTypes.YESNO, Symptoms.DILATED_PUPILS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje nadmmierna reakcja na bodźce?", QuestionTypes.YESNO, Symptoms.OVERREACTION_TO_STIMULI));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierze jest w śpiączce?", QuestionTypes.YESNO, Symptoms.COMA));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy wystąpiło porażenie układu oddechowego?", QuestionTypes.YESNO, Symptoms.RESPIRATORY_SYSTEM_PARALYSIS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma opadającą żuchwę?", QuestionTypes.YESNO, Symptoms.MANDIBLE_DROOP));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje  postępujące osłabienie mięśni?", QuestionTypes.YESNO, Symptoms.PROGRESSIVE_MUSCLE_WEAKNESS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy u zwierzęcia występuje  drganie żuchwy?", QuestionTypes.YESNO, Symptoms.MANDIBULAR_CONVULSIONS));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma odruch przełykania?", QuestionTypes.YESNO, Symptoms.NO_SWALLOWING_REFLEX));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę jest odwodnione?", QuestionTypes.YESNO, Symptoms.DEHYDRATION));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę chwieję się podczas poruszania?", QuestionTypes.YESNO, Symptoms.SHAKY_GAIT));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę ma problemy z poruszaniem się?", QuestionTypes.YESNO, Symptoms.SHAKY_GAIT));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę potrząsa głową?", QuestionTypes.YESNO, Symptoms.HEAD_SHAKING));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę pochyla głowę na którąś ze stron?", QuestionTypes.YESNO, Symptoms.TILTING_THE_HEAD_TO_ONE_SIDE));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy zwierzę drapie się po uchu?", QuestionTypes.YESNO, Symptoms.SCRATCHING_THE_EAR));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy z ucha wydobywa się nieprzyjemny zapach?", QuestionTypes.YESNO, Symptoms.BAD_SMELL_FROM_THE_EAR));
        questionsVector.add(new Triplet<String, QuestionTypes, Symptoms>("Czy występuje ból podczas dotykania ucha?", QuestionTypes.YESNO, Symptoms.SORENESS_WHEN_TOUCHING_THE_EAR));
    }

    private void fillDiseasesMap() {

        // TRACHEITIS - zapalenie tchawicy
        diseasesMap.put(Diseases.TRACHEITIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.LACK_OF_APPETITE);
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.DEPRESSION);
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.VOMITING);
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.COUGH);
        diseasesMap.get(Diseases.TRACHEITIS).add(Symptoms.ENLARGED_LYMPH_NODES);

        // QUINSY - Angina
        diseasesMap.put(Diseases.QUINSY, new Vector<Symptoms>());
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.LACK_OF_APPETITE);
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.DEPRESSION);
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.VOMITING);
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.COUGH);
        diseasesMap.get(Diseases.QUINSY).add(Symptoms.ENLARGED_LYMPH_NODES);

        // GASTRITIS - zapalenie żołądka
        diseasesMap.put(Diseases.GASTRITIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.LACK_OF_APPETITE);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.VOMITING);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.DIARRHEA);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.ABDOMINAL_PAIN);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.THICKENING_OF_THE_STOMACH_WALLS);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.HIGH_NUMBER_OF_WHITE_BLOOD_CELLS);
        diseasesMap.get(Diseases.GASTRITIS).add(Symptoms.TIGHT_ABDOMINAL_WALL);

        // ALLERGIC_REACTION - reakcja alergiczna
        diseasesMap.put(Diseases.ALLERGIC_REACTION, new Vector<Symptoms>());
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.SKIN_SYMPTOMS);
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.VOMITING);
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.DIARRHEA);
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.RAPID_BREATHING);
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.INCREASED_HEART_RATE);
        diseasesMap.get(Diseases.ALLERGIC_REACTION).add(Symptoms.TISSUE_SWELLING);

        // CATARRHAL_PNEUMONIA - nieżytowe zapalenie płuc
        diseasesMap.put(Diseases.CATARRHAL_PNEUMONIA, new Vector<Symptoms>());
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.HIGHER_TEMPERATURE);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.RAPID_BREATHING);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.DYSPNOEA);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.COUGH);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.REDNESS_OF_THE_ORAL_MUCOSA);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.PURULENT_DISCHARGE_FROM_THE_NOSE);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.WEAKENED_VESICULAR_MURMURS);
        diseasesMap.get(Diseases.CATARRHAL_PNEUMONIA).add(Symptoms.ACUTE_ALVEOLAR_MURMURS);

        // MOUTH_INFECTION - zapalenie jamy ustnej
        diseasesMap.put(Diseases.MOUTH_INFECTION, new Vector<Symptoms>());
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.CHEWING_IMPAIRMENT);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.LACK_OF_APPETITE);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.REDUCED_WATER_CONSUMPTION);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.SALIVATION);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.DIFFICULTY_SWALLOWING);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.DAMAGE_TO_THE_MUCOUS_MEMBRANES);
        diseasesMap.get(Diseases.MOUTH_INFECTION).add(Symptoms.REDNESS_OF_THE_ORAL_MUCOSA);

        // JAUNDICE - żółtaczka
        diseasesMap.put(Diseases.JAUNDICE, new Vector<Symptoms>());
        diseasesMap.get(Diseases.JAUNDICE).add(Symptoms.YELLOWING_OF_THE_SKIN);
        diseasesMap.get(Diseases.JAUNDICE).add(Symptoms.ANEMIA);
        diseasesMap.get(Diseases.JAUNDICE).add(Symptoms.BLOOD_IN_THE_STOOL);
        diseasesMap.get(Diseases.JAUNDICE).add(Symptoms.DROP_IN_BODY_TEMPERATURE);
        diseasesMap.get(Diseases.JAUNDICE).add(Symptoms.ELEVATED_BILIRUBIN_LEVEL);

        // GLOMERULONEPHRITIS - kłębuszkowe zapalenie nerek
        diseasesMap.put(Diseases.GLOMERULONEPHRITIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.PALLOR_OF_THE_MUCOUS_MEMBRANES);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.APATHY);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.INCREASED_WATER_CONSUMPTION);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.RELUCTANCE_TO_MOVE);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.HIGH_BLOOD_PRESSURE);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.CLOUDY_URINE);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.BLOOD_IN_URINE);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.ELEVATED_BLOOD_UREA_LEVELS);
        diseasesMap.get(Diseases.GLOMERULONEPHRITIS).add(Symptoms.INCREASE_IN_BLOOD_CREATININE_LEVELS);

        // UROLITHIASIS - kamica układu moczowego
        diseasesMap.put(Diseases.UROLITHIASIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.UROLITHIASIS).add(Symptoms.PAIN_IN_THE_KIDNEY_AREA);
        diseasesMap.get(Diseases.UROLITHIASIS).add(Symptoms.BLOOD_IN_URINE);
        diseasesMap.get(Diseases.UROLITHIASIS).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.UROLITHIASIS).add(Symptoms.POLLAKIURIA);
        diseasesMap.get(Diseases.UROLITHIASIS).add(Symptoms.PRESENCE_OF_ERYTHROCYTES_AND_LEUKOCYTES_IN_THE_URINE);

        // SUNSTROKE - udar słoneczny
        diseasesMap.put(Diseases.SUNSTROKE, new Vector<Symptoms>());
        diseasesMap.get(Diseases.SUNSTROKE).add(Symptoms.REDNESS_OF_THE_ORAL_MUCOSA);
        diseasesMap.get(Diseases.SUNSTROKE).add(Symptoms.INCREASED_HEART_RATE);
        diseasesMap.get(Diseases.SUNSTROKE).add(Symptoms.DYSPNOEA);
        diseasesMap.get(Diseases.SUNSTROKE).add(Symptoms.DECREASE_IN_THE_AMOUNT_OF_URINE_PASSED);
        diseasesMap.get(Diseases.SUNSTROKE).add(Symptoms.SEIZURES);

        // RABIES - wścieklizna
        diseasesMap.put(Diseases.RABIES, new Vector<Symptoms>());
        diseasesMap.get(Diseases.RABIES).add(Symptoms.AGGRESSION);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.DISTORTED_APPETITE);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.DILATED_PUPILS);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.SALIVATION);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.OVERREACTION_TO_STIMULI);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.SEIZURES);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.COMA);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.RESPIRATORY_SYSTEM_PARALYSIS);
        diseasesMap.get(Diseases.RABIES).add(Symptoms.MANDIBLE_DROOP);

        // BOTULISM - botulism
        diseasesMap.put(Diseases.BOTULISM, new Vector<Symptoms>());
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.PROGRESSIVE_MUSCLE_WEAKNESS);
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.MANDIBULAR_CONVULSIONS);
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.DILATED_PUPILS);
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.DEPRESSION);
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.NO_SWALLOWING_REFLEX);
        diseasesMap.get(Diseases.BOTULISM).add(Symptoms.DEHYDRATION);

        // SALMONELLOSIS - salmonelloza
        diseasesMap.put(Diseases.SALMONELLOSIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.SALMONELLOSIS).add(Symptoms.FEVER);
        diseasesMap.get(Diseases.SALMONELLOSIS).add(Symptoms.APATHY);
        diseasesMap.get(Diseases.SALMONELLOSIS).add(Symptoms.LACK_OF_APPETITE);
        diseasesMap.get(Diseases.SALMONELLOSIS).add(Symptoms.DIARRHEA);
        diseasesMap.get(Diseases.SALMONELLOSIS).add(Symptoms.BLOOD_IN_THE_STOOL);

        // CEREBRAL_ISCHEMIA - niedokrwienie mózgu
        diseasesMap.put(Diseases.CEREBRAL_ISCHEMIA, new Vector<Symptoms>());
        diseasesMap.get(Diseases.CEREBRAL_ISCHEMIA).add(Symptoms.APATHY);
        diseasesMap.get(Diseases.CEREBRAL_ISCHEMIA).add(Symptoms.SHAKY_GAIT);
        diseasesMap.get(Diseases.CEREBRAL_ISCHEMIA).add(Symptoms.INCOHERENCE_OF_MOVEMENTS);
        diseasesMap.get(Diseases.CEREBRAL_ISCHEMIA).add(Symptoms.DILATED_PUPILS);

        // OTITIS - zapalenie ucha
        diseasesMap.put(Diseases.OTITIS, new Vector<Symptoms>());
        diseasesMap.get(Diseases.OTITIS).add(Symptoms.HEAD_SHAKING);
        diseasesMap.get(Diseases.OTITIS).add(Symptoms.TILTING_THE_HEAD_TO_ONE_SIDE);
        diseasesMap.get(Diseases.OTITIS).add(Symptoms.SCRATCHING_THE_EAR);
        diseasesMap.get(Diseases.OTITIS).add(Symptoms.BAD_SMELL_FROM_THE_EAR);
        diseasesMap.get(Diseases.OTITIS).add(Symptoms.SORENESS_WHEN_TOUCHING_THE_EAR);
    }

    private void addSymptomToOccurredSymptomsVector()
    {
        occurredSymptomsVector.add(questionsVector.get(currentQuestionId).getValue3());
    }

    private boolean randNewQuestion()
    {
        currentQuestionId = randWithoutDuplicates.getNextNumber();
        if(currentQuestionId != -1) {
            labelQuestionText.setText(questionsVector.get(currentQuestionId).getValue1());
        }
        else {
            yesButton.setDisable(true);
            noButton.setDisable(true);
            labelQuestionText.setText("Koniec pytań");
        }

        return true;
    }

    public void initialize()
    {
        fillQuestionsVector();
        fillDiseasesMap();
        randWithoutDuplicates = new RandWithoutDuplicates(questionsVector.size());

        randNewQuestion();
    }

    private void refreshDiseasesStatistics(){
        diseasesStatisticMap.clear();

        for (Symptoms occuredSymptom : occurredSymptomsVector) {

            for (Map.Entry<Diseases, Vector<Symptoms>> disease : diseasesMap.entrySet()) {

                if (disease.getValue().contains(occuredSymptom)) {

                    if (diseasesStatisticMap.containsKey(disease.getKey()) == false) {
                        diseasesStatisticMap.put(disease.getKey(), 1);
                    }
                    else {
                        diseasesStatisticMap.put(disease.getKey(), diseasesStatisticMap.get(disease.getKey())+1);
                    }
                }
            }
        }
    }

    private void refreshChart(){
        diseasesChart.getData().clear();
        diseasesChart.setAnimated(false);
        yAxis.setLabel("Symptoms statistics (%)");

        // Calculate percentage of detected symptoms
        Map<Diseases, Double> diseasesStatistiProcentMap = new HashMap<>();
        for (Map.Entry<Diseases, Integer>  disease : diseasesStatisticMap.entrySet()) {
            Double prc = 100.0 / diseasesMap.get(disease.getKey()).size() * disease.getValue();
            diseasesStatistiProcentMap.put(disease.getKey(), prc);
        }

        // Sort map
        Map<Diseases, Double> diseasesStatistiSortetProcentMap = sortByValue(diseasesStatistiProcentMap);
//        for (Map.Entry<Diseases, Double> disease : diseasesStatistiSortetProcentMap.entrySet()) {
//            System.out.println("num: " + disease.getKey().toString() + ": " + disease.getValue());
//        }
//        System.out.println("================================= ");

        // Add first 4 diseases to map
        int counter = 0;
        for (Map.Entry<Diseases, Double>  disease : diseasesStatistiSortetProcentMap.entrySet()) {
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(disease.getKey().toString(), disease.getValue()));

            diseasesChart.getData().addAll(series);
            if (++counter >=4)
                break;
        }
    }

    private static Map<Diseases, Double> sortByValue(Map<Diseases, Double> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Diseases, Double>> list = new LinkedList<Map.Entry<Diseases, Double>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Diseases, Double>>() {
            public int compare(Map.Entry<Diseases, Double> o1, Map.Entry<Diseases, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Diseases, Double> sortedMap = new LinkedHashMap<Diseases, Double>();
        for (Map.Entry<Diseases, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    @FXML
    protected void onYesButtonClick() {
        if(currentQuestionId != -1) {
            addSymptomToOccurredSymptomsVector();
            refreshDiseasesStatistics();
            refreshChart();
            randNewQuestion();
        }
    }

    @FXML
    protected void onNoButtonClick() {
        if(currentQuestionId != -1) {
            refreshDiseasesStatistics();
            refreshChart();
            randNewQuestion();
        }
    }
}