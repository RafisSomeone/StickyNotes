package Kernel;

public class NoteSettings {



    private String font;
    private String fontColor;
    private String backgroundColor;
    private String fontsize;

public NoteSettings()
{
    this.font = "-fx-font-family: DejaVu Sans;";
    this.fontColor = "-fx-text-fill: #000000;";
    this.backgroundColor= "-fx-control-inner-background: #FF0000;";
    this.fontsize = "-fx-font-size: medium;";

}
public String getFontsize()
{
    return this.fontsize.substring(this.fontsize.lastIndexOf(' '),this.fontsize.lastIndexOf(';'));
}

public String getSettings()
{

    return font+" "+fontColor+" "+backgroundColor+" "+fontsize;

}

public String getFont()
{
    return this.font.substring(this.font.lastIndexOf(':')+1,this.font.lastIndexOf(';'));

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
        this.font = "-fx-font-family: "+font+";";
    }

    public void setFontColor(String fontColor) {
        this.fontColor = "-fx-text-fill: "+fontColor+";";
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = "-fx-control-inner-background: "+backgroundColor+";";
    }
    public void setFontsize(String fontsize)
    {
        this.fontsize = "-fx-font-size: "+fontsize+";";
    }
}
