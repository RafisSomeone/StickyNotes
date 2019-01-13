package Kernel;

public class NoteSettings {



    private String font;
    private String fontColor;
    private String backgroundColor;

public NoteSettings()
{
    this.font = "-fx-font-family: DejaVu Sans;";
    this.fontColor = "-fx-text-fill: #000000;";
    this.backgroundColor= "-fx-control-inner-background: #FFFFFF;";


}

public String getSettings()
{

    return font+" "+fontColor+" "+backgroundColor+" ";

}

public String getFont()
{
    return this.font.substring(this.font.lastIndexOf(' '),this.font.lastIndexOf(';'));

}
public String getFontColor()
{
    return this.fontColor.substring(this.fontColor.lastIndexOf(" "),this.fontColor.lastIndexOf(";"));
}
public String getBackgroundColor()
{
    return this.backgroundColor.substring(this.backgroundColor.lastIndexOf(" "),this.backgroundColor.lastIndexOf(";"));
}

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
