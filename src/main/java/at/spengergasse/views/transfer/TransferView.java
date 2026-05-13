package at.spengergasse.views.transfer;

import at.spengergasse.domain.Account;
import at.spengergasse.domain.AccountException;
import at.spengergasse.service.BankService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.time.LocalDate;

@PageTitle("Transfer")
@Route("empty")
@Menu(order = 1, icon = LineAwesomeIconUrl.DOLLAR_SIGN_SOLID)
public class TransferView extends VerticalLayout {
    private final Button removeAll = new Button("Remove all accounts");
    private final Button add10Accounts = new Button("Add 10 accounts");
    private final Button addWrongAccount = new Button("Add wrong accounts");

    private final Grid<Account> grid = new Grid<>(Account.class, false);
    private final BankService bankService;


    public TransferView(@Autowired BankService bankService) {
        this.bankService = bankService;
        setSpacing(true);

        grid.addColumn(a -> a.getAccountId())
                .setHeader("Account ID")
                .setSortable(true);
        grid.addColumn(a -> a.getFirstName())
                .setHeader("First Name")
                .setSortable(true);
        grid.addColumn(a -> a.getOpeningDate())
                .setHeader("Opening Date")
                .setSortable(true);

        Image img = new Image("icons/logo.png", "Logo");
        img.setWidth("32px");
        grid.addColumn(a -> a.getAccountType())
                .setHeader(new HorizontalLayout(img, new Span("AccType")))
                .setSortable(true);


        grid.addColumn(a -> a.getAmount())
                .setHeader("Amount")
                .setSortable(true);
        grid.addColumn(a -> a.getActive())
                .setHeader("Active")
                .setSortable(true);
        grid.addColumn(a -> a.getActive() ? "Y" : "N")
                .setHeader("Active")
                .setSortable(true);
        grid.addComponentColumn(a -> {
                    Checkbox cb = new Checkbox(a.getActive());
                    cb.setReadOnly(true);
                    return cb;
                })
                .setHeader("Active")
                .setSortable(true);


        setSizeFull();
        grid.setSizeFull();
        removeAll.addClickListener(e -> removeAllAccounts());
        add10Accounts.addClickListener(e -> add10Accounts());
        addWrongAccount.addClickListener(e -> addWrongAccount());
        HorizontalLayout buttons = new HorizontalLayout(removeAll, add10Accounts, addWrongAccount);
        buttons.setSpacing(true);
        add(buttons);
        add(grid);
        reload();
    }

    private void addWrongAccount() {
        try {
            Account a = new Account("Fritz", LocalDate.now(), "Savings", -2000.0, true);
            bankService.addAccount(a);
            reload();
        } catch (AccountException e) {
            Notification.show(e.getMessage());
        }
    }

    private void add10Accounts() {
        try {
            bankService.fillTestData(10);
            removeAll.setEnabled(true);
            reload();
        } catch (AccountException e) {
            Notification.show(e.getMessage());
        }
    }

    private void removeAllAccounts() {
        try {
            bankService.removeAllAccounts();
            removeAll.setEnabled(false);
            reload();
        } catch (AccountException e) {
            Notification.show(e.getMessage());
        }

    }

    private void reload() {
        grid.setItems(bankService.findAll());
    }

}
