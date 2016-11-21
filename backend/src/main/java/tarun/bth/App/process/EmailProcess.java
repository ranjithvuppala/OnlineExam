package tarun.bth.App.process;

import tarun.bth.App.db.entity.Email;

import javax.ws.rs.core.Response;

public interface EmailProcess {

    Integer send(Email email);
}
