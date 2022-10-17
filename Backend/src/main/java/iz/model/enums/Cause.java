package iz.model.enums;

public enum Cause {
    PC_DROPPED,
    LIQUID_SPILL,
    OVERCLOCKED,
    DUST,
    SOFTWARE_NEGLECT,
    ANTIVIRUS;

    public static String getNodeName(Cause cause){
        switch(cause){
            case PC_DROPPED:
                return "PC_dropped";
            case LIQUID_SPILL:
                return "Liquid_spill";
            case OVERCLOCKED:
                return "Overclocked";
            case DUST:
                return "Dust_and_dirt";
            case SOFTWARE_NEGLECT:
                return "Software_neglect";
            case ANTIVIRUS:
                return "Antivirus";
            default:
                return "NO NODE FOUND";
        }
    }
}