package tarun.bth.App.process;

import tarun.bth.App.db.entity.User;




public interface UserProcess {

    User verify(User user);
    User verifyForPost(User user);
    Integer updateResult(User user);

}