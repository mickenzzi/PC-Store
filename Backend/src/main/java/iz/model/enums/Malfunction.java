package iz.model.enums;

public enum Malfunction {
    CABLE_DISCONNECTED,
    COOLING_MALFUNCTION,
    MOB_MALFUNCTION,
    ETHERNET_CARD,
    AUDIO_CARD_MALFUNCTION,
    CPU_MALFUNCTION,
    PSU_MALFUNCTION,
    STORAGE_MALFUNCTION,
    GPU_MALFUNCTION,
    RAM_MALFUNCTION,
    PORTS_MALFUNCTION,
    ANTIVIRUS_PERMISSION,
    BIOS_OUTDATED,
    SYSTEM_FILES_MALFUNCTION,
    MALICIOUS_SOFTWARE,
    DRIVERS_MALFUNCTION;

    public static String getNodeName(Malfunction malfunction){
        switch(malfunction){
            case CABLE_DISCONNECTED:
                return "Cable_disconnected";
            case COOLING_MALFUNCTION:
                return "Cooling_malfunction";
            case MOB_MALFUNCTION:
                return "MOBO_malfunction";
            case ETHERNET_CARD:
                return "Ethernet_card_malfunction";
            case AUDIO_CARD_MALFUNCTION:
                return "Audio_card_malfunction";
            case CPU_MALFUNCTION:
                return "CPU_malfunction";
            case PSU_MALFUNCTION:
                return "PSU_malfunction";
            case STORAGE_MALFUNCTION:
                return "Storage_malfunction";
            case GPU_MALFUNCTION:
                return "GPU_malfunction";
            case RAM_MALFUNCTION:
                return "RAM_malfunction";
            case PORTS_MALFUNCTION:
                return "Ports_malfunction";
            case ANTIVIRUS_PERMISSION:
                return "Antivirus_permission";
            case BIOS_OUTDATED:
                return "BIOS_Outdated";
            case SYSTEM_FILES_MALFUNCTION:
                return "System_files_malfunction";
            case MALICIOUS_SOFTWARE:
                return "Malicious_software";
            case DRIVERS_MALFUNCTION:
                return "Drivers_malfunction";
            default:
                return "NO NODE FOUND";
        }
    }
    public static String toString(Malfunction malfunction){
        switch(malfunction){
            case CABLE_DISCONNECTED:
                return "Cable is disconnected";
            case COOLING_MALFUNCTION:
                return "There is a cooling malfunction";
            case MOB_MALFUNCTION:
                return "There is a motherboard malfunction";
            case ETHERNET_CARD:
                return "There is an ethernet card malfunction";
            case AUDIO_CARD_MALFUNCTION:
                return "There is an audio card malfunction";
            case CPU_MALFUNCTION:
                return "There is a CPU malfunction";
            case PSU_MALFUNCTION:
                return "There is a PSU malfunction";
            case STORAGE_MALFUNCTION:
                return "There is a storage malfunction";
            case GPU_MALFUNCTION:
                return "There is a GPU malfunction";
            case RAM_MALFUNCTION:
                return "There is a ram malfunction";
            case PORTS_MALFUNCTION:
                return "There is ports malfunction";
            case ANTIVIRUS_PERMISSION:
                return "Antivirus is not allowing installation/download";
            case BIOS_OUTDATED:
                return "Bios is outdated";
            case SYSTEM_FILES_MALFUNCTION:
                return "There is a system files malfunction";
            case MALICIOUS_SOFTWARE:
                return "There is a malware in your system";
            case DRIVERS_MALFUNCTION:
                return "There is a driver malfunction";
            default:
                return "NO NODE FOUND";
        }
    }
}