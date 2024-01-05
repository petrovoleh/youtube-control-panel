package youtube.controlpanel.model.chart_dataset;

import com.google.api.services.youtube.model.Video;
import org.jfree.data.category.DefaultCategoryDataset;
import youtube.controlpanel.model.data.VideoData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChartDataset implements Dataset {
    ArrayList<DefaultCategoryDataset> datasets;
    Video _video;

    public ChartDataset(Video video) {
        datasets = new ArrayList<>();
        _video = video;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        datasets.add(dataset);

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        datasets.add(dataset1);

        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        datasets.add(dataset2);

        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        datasets.add(dataset3);
    }

    // Creates a dataset for the charts based on video statistics
    @Override
    public void updateData() {
        String series = "Video Views";

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);

        datasets.get(0).addValue(_video.getStatistics().getViewCount(), series, currentDateTime);
        datasets.get(1).addValue(_video.getStatistics().getLikeCount(), series, currentDateTime);
        datasets.get(2).addValue(_video.getStatistics().getCommentCount(), series, currentDateTime);
        datasets.get(3).addValue(_video.getStatistics().getViewCount(), series, currentDateTime); // Youtube video earnings missing
    }

    @Override
    public DefaultCategoryDataset getViewsDataset() {
        return datasets.get(0);
    }

    @Override
    public DefaultCategoryDataset getLikesDataset() {
        return datasets.get(1);
    }

    @Override
    public DefaultCategoryDataset getCommentsDataset() {
        return datasets.get(2);
    }

    @Override
    public DefaultCategoryDataset getEarningsDataset() {
        return datasets.get(3);
    }
}
