package uk.co.mruoc.race.model;

import uk.co.mruoc.race.model.Split.SplitBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileLinesToSplitsConverter {

    private final DistanceProvider distanceProvider;

    public FileLinesToSplitsConverter(DistanceProvider distanceProvider) {
        this.distanceProvider = distanceProvider;
    }

    public List<Split> toSplits(List<FileLine> lines) {
        List<Split> splits = new ArrayList<>();
        BigDecimal startDistance = BigDecimal.ZERO;
        for (int i = 1; i < lines.size(); i++) {
            FileLine line1 = lines.get(i - 1);
            FileLine line2 = lines.get(i);
            Split split = buildSplit(line1, line2, startDistance);
            splits.add(split);
            startDistance = startDistance.add(split.getDistance());
        }
        return splits;
    }

    private Split buildSplit(FileLine startLine, FileLine endLine, BigDecimal startDistance) {
        BigDecimal splitDistance = getSplitDistance(startLine, endLine);
        return new SplitBuilder()
                .setCarId(startLine.getCarId())
                .setEndCheckpointId(endLine.getCheckpointId())
                .setRetired(endLine.isRetired())
                .setStartTime(startLine.getTime())
                .setEndTime(endLine.getTime())
                .setStartDistance(startDistance)
                .setSplitDistance(splitDistance)
                .build();
    }

    private BigDecimal getSplitDistance(FileLine line1, FileLine line2) {
        int checkpointId1 = line1.getCheckpointId();
        int checkpointId2 = line2.getCheckpointId();
        if (line2.isRetired())
            checkpointId2 = distanceProvider.getNextCheckpointId(checkpointId1);
        return distanceProvider.getDistanceBetweenCheckpoints(checkpointId1, checkpointId2);
    }

}
