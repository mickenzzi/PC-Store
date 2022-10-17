package iz.model.enums;

public enum Symptom {
    REBOOT,
    BEEPING,
    SLOW,
    CANT_TURN_ON,
    LOUD,
    CANT_BOOT,
    OVERHEATING,
    SMOKE,
    BLUE_SCREEN,
    NO_SPACE_AVAILABLE,
    CANT_DOWNLOAD_SOFTWARE,
    CANT_INSTALL_SOFTWARE,
    FILES_CORRUPTED,
    FILES_MISSING,
    MONITOR_FLICKERING,
    VIDEO_FREEZE,
    FPS_DROP,
    PIXELATION,
    NO_ETHERNET,
    NO_WIFI,
    SLOW_BROWSING,
    NO_AUDIO,
    SOUND_CHOPPING,
    AUDIO_FREEZE;

    public static String getNodeName(Symptom symptom){
        switch (symptom){
            case REBOOT:
                return "PC_reboot";
            case BEEPING:
                return "Beeping";
            case SLOW:
                return "PC_slow";
            case CANT_TURN_ON:
                return "PC_cant_turn_on";
            case LOUD:
                return "PC_loud";
            case CANT_BOOT:
                return "PC_cant_boot";
            case OVERHEATING:
                return "Overheating";
            case SMOKE:
                return "Smoke";
            case BLUE_SCREEN:
                return "Blue_screen";
            case NO_SPACE_AVAILABLE:
                return "No_space_available";
            case CANT_DOWNLOAD_SOFTWARE:
                return "Cant_download_software";
            case CANT_INSTALL_SOFTWARE:
                return "Cant_install_software";
            case FILES_CORRUPTED:
                return "Files_corrupted";
            case FILES_MISSING:
                return "Files_missing";
            case MONITOR_FLICKERING:
                return "Monitor_flickering";
            case VIDEO_FREEZE:
                return "Video_freeze";
            case FPS_DROP:
                return "FPS_drop";
            case PIXELATION:
                return "Pixelation";
            case NO_ETHERNET:
                return "No_ethernet";
            case NO_WIFI:
                return "No_wifi";
            case SLOW_BROWSING:
                return "Slow_browsing";
            case NO_AUDIO:
                return "No_audio";
            case SOUND_CHOPPING:
                return "Sound_chopping";
            case AUDIO_FREEZE:
                return "Audio_freeze";
            default:
                return "NO NODE FUND";
        }
    }
}