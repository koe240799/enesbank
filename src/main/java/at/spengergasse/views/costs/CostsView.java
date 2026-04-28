package at.spengergasse.views.costs;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Costs")
@Route("delivery")
@Menu(order = 2, icon = LineAwesomeIconUrl.WALLET_SOLID)
public class CostsView extends VerticalLayout {

    public CostsView() {
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

        H2 costs = new H2("Transfer Costs");

        H2 zone0 = new H2("Inland");
        Paragraph cost0 = new Paragraph("Kosten: 0 Euro");
        Paragraph max0 = new Paragraph("maximaler Betrag: unlimitiert");

        H2 zone1 = new H2("Deutschland");
        Paragraph cost1 = new Paragraph("Kosten: 2 Euro");
        Paragraph max1 = new Paragraph("maximaler Betrag: 1000 Euro");

        H2 zone2 = new H2("Europa");
        Paragraph cost2 = new Paragraph("Kosten: 4 Euro");
        Paragraph max2 = new Paragraph("maximaler Betrag: 500 Euro");

        H2 zone3 = new H2("USA");
        Paragraph cost3 = new Paragraph("Kosten: 6");
        Paragraph max3 = new Paragraph("maximaler Betrag: 400 Euro");

        H2 zone4 = new H2("Inland");
        Paragraph cost4 = new Paragraph("Kosten: 12 Euro");
        Paragraph max4 = new Paragraph("maximaler Betrag: 200 Euro");

        add(companyname, subtitle,
                zone0, cost0, max0,
                zone1, cost1, max1,
                zone2, cost2, max2,
                zone3, cost3, max3,
                zone4, cost4, max4);



    }

}
