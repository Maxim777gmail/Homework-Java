package telecom.subscribers;

import telecom.subscribers.MobileSubscriber;

public class InternetSubscriber extends MobileSubscriber {
    private String staticIpAddress;
    private int speedLimitMbps;
    private boolean parentalControlActive = false;

    // Специализированный метод: Привязать статический IP
    public void allocateStaticIp(String ipAddress) {
        this.staticIpAddress = ipAddress;
        System.out.println("Для учетной записи выделен статический IP: " + ipAddress);
    }

    // Специализированный метод: Турбокнопка (увеличение скорости)
    public void activateTurboButton(int extraSpeedMbps) {
        this.speedLimitMbps += extraSpeedMbps;
        System.out.println("Скорость увеличена на " + extraSpeedMbps + " Мбит/с.");
    }

    // Специализированный метод: Родительский контроль
    public void toggleParentalControl(boolean active) {
        this.parentalControlActive = active;
        System.out.println("Родительский контроль: " + (active ? "Включен" : "Выключен"));
    }
}
