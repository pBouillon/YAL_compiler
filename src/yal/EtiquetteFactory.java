package yal;

import java.util.HashMap;

public class EtiquetteFactory {

    private static EtiquetteFactory INSTANCE
            = new EtiquetteFactory() ;

    // Inferieur
    private final String SI_INF    = "siInf" ;
    private final String SINON_INF = "sinonInf" ;
    private final String FSI_INF   = "finSiInf" ;

    // Superieur
    private final String SI_SUP    = "siSup" ;
    private final String SINON_SUP = "sinonSup" ;
    private final String FSI_SUP   = "finSiSup" ;

    // Egal
    private final String SI_EG    = "siEg" ;
    private final String SINON_EG = "sinonEg" ;
    private final String FSI_EG   = "finSiEg" ;

    // Non Egal
    private final String SI_NEG    = "siNonEg" ;
    private final String SINON_NEG = "sinonNonEg" ;
    private final String FSI_NEG   = "finSiNonEg" ;

    // Raw evals
    private final String SI    = "si" ;
    private final String ALORS    = "alors" ;
    private final String SINON = "sinon" ;
    private final String FSI   = "fin" ;

    private HashMap<String, Integer> etiqs ;

    private EtiquetteFactory() {
        etiqs = new HashMap<>() ;
        // inferieur
        etiqs.put(SI_INF, 0) ;
        etiqs.put(SINON_INF, 0) ;
        etiqs.put(FSI_INF, 0) ;
        // superieur
        etiqs.put(SI_SUP, 0) ;
        etiqs.put(SINON_SUP, 0) ;
        etiqs.put(FSI_SUP, 0) ;
        // egal
        etiqs.put(SI_EG, 0) ;
        etiqs.put(SINON_EG, 0) ;
        etiqs.put(FSI_EG, 0) ;
        // dif
        etiqs.put(SI_NEG, 0) ;
        etiqs.put(SINON_NEG, 0) ;
        etiqs.put(FSI_NEG, 0) ;
        // raw
        etiqs.put(SI, 0) ;
        etiqs.put(ALORS, 0) ;
        etiqs.put(SINON, 0) ;
        etiqs.put(FSI, 0) ;
    }

    public static EtiquetteFactory getInstance() {
        return INSTANCE;
    }

    // Inferieur
    public String getNextSiInf() {
        return SI_INF + (etiqs.get(SI_INF) + 1) ;
    }

    public String getSiInf() {
        etiqs.put(SI_INF, etiqs.get(SI_INF) + 1) ;
        return SI_INF + etiqs.get(SI_INF) ;
    }

    public String getNextSiNonInf() {
        return SINON_INF + (etiqs.get(SINON_INF) + 1) ;
    }

    public String getSiNonInf() {
        etiqs.put(SINON_INF, etiqs.get(SINON_INF) + 1) ;
        return SINON_INF + etiqs.get(SINON_INF) ;
    }

    public String getNextFinSiInf() {
        return FSI_INF + (etiqs.get(FSI_INF) + 1) ;
    }

    public String getFinSiInf() {
        etiqs.put(FSI_INF, etiqs.get(FSI_INF) + 1) ;
        return FSI_INF + etiqs.get(FSI_INF) ;
    }

    // Superieur
    public String getNextSiSup() {
        return SI_SUP + (etiqs.get(SI_SUP) + 1) ;
    }

    public String getSiSup() {
        etiqs.put(SI_SUP, etiqs.get(SI_SUP) + 1) ;
        return SI_SUP + etiqs.get(SI_SUP) ;
    }

    public String getNextSiNonSup() {
        return SINON_SUP + (etiqs.get(SINON_SUP) + 1) ;
    }

    public String getSiNonSup() {
        etiqs.put(SINON_SUP, etiqs.get(SINON_SUP) + 1) ;
        return SINON_SUP + etiqs.get(SINON_SUP) ;
    }

    public String getNextFinSiSup() {
        return FSI_SUP + (etiqs.get(FSI_SUP) + 1) ;
    }

    public String getFinSiSup() {
        etiqs.put(FSI_SUP, etiqs.get(FSI_SUP) + 1) ;
        return FSI_SUP + etiqs.get(FSI_SUP) ;
    }

    // Egal
    public String getNextSiEg() {
        return SI_EG + (etiqs.get(SI_EG) + 1) ;
    }

    public String getSiEg() {
        etiqs.put(SI_EG, etiqs.get(SI_EG) + 1) ;
        return SI_EG + etiqs.get(SI_EG) ;
    }

    public String getNextSiNonEg() {
        return SINON_EG + (etiqs.get(SINON_EG) + 1) ;
    }

    public String getSiNonEg() {
        etiqs.put(SINON_EG, etiqs.get(SINON_EG) + 1) ;
        return SINON_EG + etiqs.get(SINON_EG) ;
    }

    public String getNextFinSiEg() {
        return FSI_EG + (etiqs.get(FSI_EG) + 1) ;
    }

    public String getFinSiEg() {
        etiqs.put(FSI_EG, etiqs.get(FSI_EG) + 1) ;
        return FSI_EG + etiqs.get(FSI_EG) ;
    }

    // Non Egal
    public String getNextSiNeg() {
        return SI_NEG + (etiqs.get(SI_NEG) + 1) ;
    }

    public String getSiNeg() {
        etiqs.put(SI_NEG, etiqs.get(SI_NEG) + 1) ;
        return SI_NEG + etiqs.get(SI_NEG) ;
    }

    public String getNextSiNonNeg() {
        return SINON_NEG + (etiqs.get(SINON_NEG) + 1) ;
    }

    public String getSiNonNeg() {
        etiqs.put(SINON_NEG, etiqs.get(SINON_NEG) + 1) ;
        return SINON_NEG + etiqs.get(SINON_NEG) ;
    }

    public String getNextFinSiNeg() {
        return FSI_NEG + (etiqs.get(FSI_NEG) + 1) ;
    }

    public String getFinSiNeg() {
        etiqs.put(FSI_NEG, etiqs.get(FSI_NEG) + 1) ;
        return FSI_NEG + etiqs.get(FSI_NEG) ;
    }

    // Raw
    public String getNextSi() {
        return SI + (etiqs.get(SI) + 1) ;
    }

    public String getSi() {
        etiqs.put(SI, etiqs.get(SI) + 1) ;
        return SI + etiqs.get(SI) ;
    }

    public String getNextAlors() {
        return ALORS + (etiqs.get(ALORS) + 1) ;
    }

    public String getAlors() {
        etiqs.put(ALORS, etiqs.get(ALORS) + 1) ;
        return ALORS + etiqs.get(ALORS) ;
    }

    public String getNextSinon() {
        return SINON + (etiqs.get(SINON) + 1) ;
    }

    public String getSinon() {
        etiqs.put(SINON, etiqs.get(SINON) + 1) ;
        return SINON + etiqs.get(SINON) ;
    }

    public String getNextFsi() {
        return FSI + (etiqs.get(FSI) + 1) ;
    }

    public String getFsi() {
        etiqs.put(FSI, etiqs.get(FSI) + 1) ;
        return FSI + etiqs.get(FSI) ;
    }
}
