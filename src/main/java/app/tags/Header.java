package app.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Header extends TagSupport {
    @Override
    public int doStartTag() {
        String header = "<header><h2>Welcome to Java handbook!</h2><hr></hr></header>";
        JspWriter out = pageContext.getOut();
        try {
            out.write(header);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
