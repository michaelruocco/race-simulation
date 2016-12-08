package uk.co.mruoc.race;

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
            BigDecimal splitDistance = getSplitDistance(line1, line2);
            Split split = new Split(line1, line2, startDistance, splitDistance);
            splits.add(split);
            startDistance = startDistance.add(splitDistance);
        }
        return splits;
    }

    private BigDecimal getSplitDistance(FileLine line1, FileLine line2) {
        int checkpointId1 = line1.getCheckpointId();
        int checkpointId2 = line2.getCheckpointId();
        if (line2.isRetired())
            checkpointId2 = distanceProvider.getNextCheckpointId(checkpointId1);
        return distanceProvider.getDistanceBetweenCheckpoints(checkpointId1, checkpointId2);
    }

}
