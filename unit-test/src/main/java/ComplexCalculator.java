/**
 * @Author : 吕茂华
 * @Date: 2024/5/14 下午3:50
 * @Description:
 */
public class ComplexCalculator {
    private SwitchService switchService;
    public int add(int a, int b) {
        return switchService.isOpen()? 2 * (a + b) : a + b;
    }

    public ComplexCalculator(SwitchService switchService) {
        this.switchService = switchService;
    }

    public void setSwitchService(SwitchService switchService) {
        this.switchService = switchService;
    }
}
