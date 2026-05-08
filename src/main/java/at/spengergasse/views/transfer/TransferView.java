package at.spengergasse.views.transfer;

import at.spengergasse.domain.Account;
import at.spengergasse.domain.AccountException;
import at.spengergasse.service.BankService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
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

    private final Grid<Account> grid = new Grid<>(Account.class, true);
    private final BankService bankService;


    public TransferView(@Autowired BankService bankService) {
        this.bankService = bankService;
        setSpacing(true);

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
