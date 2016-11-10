package tarun.bth.App.process;

import tarun.bth.App.db.OptionDAO;
import tarun.bth.App.db.entity.Option;


import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;


public class OptionProcessDbImpl implements OptionProcess {

    private OptionDAO optionDAO;

    public OptionProcessDbImpl(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    @Override
    public List<Option> getAllOptions() {
        return optionDAO.getAllOptions() ;
    }


    @Override
    public Option create(Option option) {
        return this.optionDAO.findOptionById(this.optionDAO.create(option));
    }

    @Override
    public Option update(Integer option_id, Option updatedexamPaper) throws NotFoundException {
        Option option = this.find(option_id);
        option.setOption(updatedexamPaper.getOption());

        this.optionDAO.update(option);
        return option;
    }

    @Override
    public Option find(Integer id) throws NotFoundException {
        return (Option) Optional
                .ofNullable(this.optionDAO.findOptionById(id))
                .orElseThrow(() -> new NotFoundException("OptionName does not exist"));
    }

    @Override
    public void delete(Integer option_id) {
        this.optionDAO.delete(option_id);
    }

    /*@Override
    public List<OptionName> getOnlyOptions() {
        return this.optionDAO.getOnlyOptions();
    }*/
}
