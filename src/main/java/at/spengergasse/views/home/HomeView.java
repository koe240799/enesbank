package at.spengergasse.views.home;

import com.vaadin.copilot.shaded.reactor.netty.http.internal.Http3;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.hibernate.dialect.aggregate.H2AggregateSupport;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {


        setSpacing(true);

        H1 companyname = new H1("Enes Bank");
        companyname.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "1rem");


        H2 subtitle = new H2("... the best bank...");
        subtitle.getStyle()
                .set("margin", "0")
                .set("color", "gray");


        Image img = new Image("images/logo.png", "placeholder logo");
        img.setWidth("200px");


        Paragraph p1 = new Paragraph("Vertrauen und Sicherheit stehen im Mittelpunkt unseres Handelns. Als verlässliche Bank bieten wir Ihnen eine stabile Grundlage für Ihre finanziellen Entscheidungen und unterstützen Sie dabei, Ihre Ziele nachhaltig zu erreichen. Dabei setzen wir auf Transparenz, Verantwortung und langfristige Partnerschaften.");
        p1.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p2 = new Paragraph("Mit innovativen und digitalen Lösungen machen wir Banking so einfach und flexibel wie möglich. Ob Online-Banking, mobile Anwendungen oder klassische Services – Sie haben jederzeit und überall Zugriff auf Ihre Finanzen und behalten stets die volle Kontrolle.");
        p2.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p3 = new Paragraph("Unsere persönliche und kompetente Beratung richtet sich ganz nach Ihren individuellen Bedürfnissen. Gemeinsam entwickeln wir maßgeschneiderte Finanzlösungen, die zu Ihrer Lebenssituation passen – von der täglichen Kontoführung bis hin zu wichtigen Investitionsentscheidungen.");
        p3.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p4 = new Paragraph("Als engagierter Partner begleiten wir Sie in jeder Phase Ihres Lebens. Mit Erfahrung, Know-how und einem klaren Fokus auf Ihre Zufriedenheit setzen wir uns dafür ein, Ihre finanzielle Zukunft sicher, erfolgreich und nachhaltig zu gestalten.");
        p4.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        H3 name = new H3("KOEN GmbH");
        H3 street = new H3("Lavantgasse 65");
        H3 city = new H3("1210 Wien");
        add(companyname, subtitle, img, p1, p2, p3, p4, name, street, city);

        setSizeFull();
        setSpacing(true);
        setPadding(true);
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

}
