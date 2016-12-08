package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.util.ArrayList;
import java.util.List;

public class FileLinesToQueryTimeConverter {

    public List<ElapsedTime> toQueryTimes(List<FileLine> lines) {
        List<ElapsedTime> queryTimes = new ArrayList<>();
        for (FileLine line : lines)
            if (line.isQueried())
                queryTimes.add(line.getTime());
        return queryTimes;
    }

}
