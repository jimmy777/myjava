package libs;

public enum Season {

    // 每个值都调用构造方法。
    winter ("December through February"),
    spring ("March through May"),
    summer ("June through August"),
    fall ("September through November");

    private String span;

    Season(String months) {
        span = months;
    }

    public String getSpan(){
        return span;
    }
}
