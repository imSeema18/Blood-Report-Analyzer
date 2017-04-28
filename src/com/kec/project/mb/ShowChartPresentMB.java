package com.kec.project.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.kec.project.ejb.ChartsEJB;
import com.kec.project.ejb.RecommendEJB;
import com.kec.project.model.Report;

@SessionScoped
@ManagedBean(name = "showChartPresentMB")
public class ShowChartPresentMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = UserMB.INJECTION_NAME)
	private UserMB userMB;

	int uid;
	@EJB
	ChartsEJB charts;
	@EJB
	RecommendEJB rec;
	private LineChartModel newModelTpl;
	private LineChartModel newModelAgr;
	private LineChartModel newModelRBC;
	private LineChartModel newModelPlt;
	private LineChartModel newModelUric;

	@PostConstruct
	public void init() {
		uid = userMB.getUser().getUserId();
		checkTpl(uid);
		checkAgr(uid);
		checkRBC(uid);
		checkPlt(uid);
		checkUric(uid);

	}

	public void checkTpl(int uid) {
		List<Report> newRangeTpl = new ArrayList<Report>();
		int tId = 1;
		newRangeTpl = charts.getCompInfoPresent(uid, tId);
		if (newRangeTpl.size() > 2) {
			createLineModelsTpl(uid, newRangeTpl);
		} else {
			System.out.println("no data tpl");
			return;
		}
	}

	public void checkAgr(int uid) {
		int tId = 2;
		List<Report> newRangeAgr = new ArrayList<Report>();
		newRangeAgr = charts.getCompInfoPresent(uid, tId);
		if (newRangeAgr.size() > 2) {
			createLineModelsAgr(uid, newRangeAgr);
		} else {
			System.out.println("no data agr");
			return;
		}
	}

	public void checkUric(int uid) {
		int tId = 6;
		List<Report> newRangeUric = new ArrayList<Report>();
		newRangeUric = charts.getCompInfoPresent(uid, tId);
		if (newRangeUric.size() > 2) {
			createLineModelsUric(uid, newRangeUric);
		} else {
			System.out.println("no data uric");
			return;
		}

	}

	public void checkRBC(int uid) {
		int tId = 3;
		List<Report> newRangeRBC = new ArrayList<Report>();
		newRangeRBC = charts.getCompInfoPresent(uid, tId);
		if (newRangeRBC.size() > 2) {
			createLineModelsRBC(uid, newRangeRBC);
		} else {

			System.out.println("no data rbc");
			return;
		}

	}

	public void checkPlt(int uid) {
		int tId = 5;
		List<Report> newRangePlt = new ArrayList<Report>();
		newRangePlt = charts.getCompInfoPresent(uid, tId);
		if (newRangePlt.size() > 2) {
			createLineModelsPlt(uid, newRangePlt);
		} else {
			System.out.println("no data plt");
			return;
		}
	}

	public LineChartModel getNewModelAgr() {
		if (newModelAgr == null) {
			newModelAgr = new LineChartModel();
		}
		return newModelAgr;
	}

	public LineChartModel getNewModelTpl() {
		if (newModelTpl == null) {
			newModelTpl = new LineChartModel();
		}
		return newModelTpl;
	}

	private void createLineModelsTpl(int uid, List<Report> newRangeTpl) {
		getNewModelTpl();
		newModelTpl = initLinearModelTpl(uid, newRangeTpl);
		newModelTpl.setTitle("Total   Protein level ");
		newModelTpl.setLegendPosition("e");
		org.primefaces.model.chart.Axis yAxis = newModelTpl.getAxis(AxisType.Y);
		yAxis.setMin(4);
		yAxis.setMax(10);
		yAxis.setLabel("Range(gm/dL)");
		org.primefaces.model.chart.Axis xAxis = newModelTpl.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(20);
		newModelTpl.setAnimate(true);
		newModelTpl.setAnimate(true);
		newModelTpl.setSeriesColors("0000FF,0E920B,0E920B");
		xAxis.setLabel("Times-->");

	}

	private void createLineModelsAgr(int uid, List<Report> newRangeAgr) {
		getNewModelAgr();
		newModelAgr = initLinearModelAgr(uid, newRangeAgr);
		newModelAgr.setTitle("Albumin/Globumin ratio");
		newModelAgr.setLegendPosition("e");
		org.primefaces.model.chart.Axis yAxis = newModelAgr.getAxis(AxisType.Y);
		yAxis.setMin(0.1);
		yAxis.setMax(4);
		yAxis.setLabel("Range");
		org.primefaces.model.chart.Axis xAxis = newModelAgr.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(10);
		newModelAgr.setAnimate(true);
		newModelAgr.setSeriesColors("0000FF,0E920B,0E920B");
		xAxis.setLabel("Time -->");

	}

	private void createLineModelsRBC(int uid, List<Report> newRangeRBC) {
		getNewModelRBC();
		newModelRBC = initLinearModelRBC(uid, newRangeRBC);
		newModelRBC.setTitle("Red Blood Cells");
		newModelRBC.setLegendPosition("e");
		org.primefaces.model.chart.Axis yAxis = newModelRBC.getAxis(AxisType.Y);
		yAxis.setMin(4);
		yAxis.setMax(7);
		yAxis.setLabel("Range(million cells/microliter)");
		org.primefaces.model.chart.Axis xAxis = newModelRBC.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(10);
		newModelRBC.setAnimate(true);
		newModelRBC.setSeriesColors("0000FF,0E920B,0E920B");
		xAxis.setLabel("Time -->");

	}

	private void createLineModelsPlt(int uid, List<Report> newRangePlt) {
		getNewModelPlt();
		newModelPlt = initLinearModelPlt(uid, newRangePlt);
		newModelPlt.setTitle("Platelets count");
		newModelPlt.setLegendPosition("e");
		org.primefaces.model.chart.Axis yAxis = newModelPlt.getAxis(AxisType.Y);
		yAxis.setMin(100000);
		yAxis.setMax(500000);
		yAxis.setLabel("Range(cells/microliter)");
		org.primefaces.model.chart.Axis xAxis = newModelPlt.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(10);
		newModelPlt.setAnimate(true);
		xAxis.setLabel("Time -->");
		newModelPlt.setSeriesColors("0000FF,0E920B,0E920B");

	}

	private void createLineModelsUric(int uid, List<Report> newRangeUric) {
		getNewModelUric();
		newModelUric = initLinearModelUric(uid, newRangeUric);
		newModelUric.setTitle("Uric acid level");
		newModelUric.setLegendPosition("e");
		org.primefaces.model.chart.Axis yAxis = newModelUric.getAxis(AxisType.Y);
		yAxis.setMin(2);
		yAxis.setMax(9);
		yAxis.setLabel("Range(cells/microliter)");
		org.primefaces.model.chart.Axis xAxis = newModelUric.getAxis(AxisType.X);
		xAxis.setMin(1);
		xAxis.setMax(10);
		newModelUric.setAnimate(true);
		xAxis.setLabel("Time -->");
		newModelUric.setSeriesColors("0000FF,0E920B,0E920B");

	}

	private LineChartModel initLinearModelTpl(int uid, List<Report> newRangeTpl) {

		LineChartModel newModel = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		LineChartSeries series3 = new LineChartSeries();

		series1.setLabel("Tpl");

		for (Report newReport : newRangeTpl) {
			String rng = newReport.getBloodRange();
			float range = Float.valueOf(rng);

			int duration = newReport.getDuration();

			series1.set(duration, range);

		}
		newModel.addSeries(series1);
		String max = rec.getMaxRange(1);
		series2.set(0, Double.valueOf(max));

		series2.set(21, Double.valueOf(max));
		newModel.addSeries(series2);
		series2.setLabel("Normal");
		String min = rec.getMinRange(1);
		series3.set(0, Double.valueOf(min));

		series3.set(21, Double.valueOf(min));
		newModel.addSeries(series3);
		series3.setLabel("Normal");
		return newModel;

	}

	private LineChartModel initLinearModelAgr(int uid, List<Report> newRangeAgr) {

		LineChartModel newModel2 = new LineChartModel();

		LineChartSeries series2 = new LineChartSeries();
		LineChartSeries series22 = new LineChartSeries();
		LineChartSeries series23 = new LineChartSeries();

		series2.setLabel("AGR");

		for (Report newReport : newRangeAgr) {
			String rng = newReport.getBloodRange();
			double range = Double.valueOf(rng);
			int duration = newReport.getDuration();
			series2.set(duration, range);

		}
		newModel2.addSeries(series2);
		String max = rec.getMaxRange(2);
		series22.set(0, Double.valueOf(max));

		series22.set(21, Double.valueOf(max));
		newModel2.addSeries(series22);
		series22.setLabel("Normal");
		String min = rec.getMinRange(2);
		series23.set(0, Double.valueOf(min));

		series23.set(21, Double.valueOf(min));
		newModel2.addSeries(series23);
		series23.setLabel("Normal");
		return newModel2;

	}

	private LineChartModel initLinearModelRBC(int uid, List<Report> newRangeRBC) {
		LineChartModel newModel3 = new LineChartModel();

		LineChartSeries series3 = new LineChartSeries();
		LineChartSeries series31 = new LineChartSeries();
		LineChartSeries series32 = new LineChartSeries();

		series3.setLabel("RBC");

		for (Report newReport : newRangeRBC) {
			String rng = newReport.getBloodRange();
			double range = Double.valueOf(rng);
			int duration = newReport.getDuration();
			series3.set(duration, range);

		}
		newModel3.addSeries(series3);
		String max = rec.getMaxRangeGen(3, userMB.getUser().getGender());
		series31.set(0, Double.valueOf(max));

		series31.set(21, Double.valueOf(max));
		newModel3.addSeries(series31);
		series31.setLabel("Normal");
		String min = rec.getMinRangeGen(3, userMB.getUser().getGender());
		series32.set(0, Double.valueOf(min));

		series32.set(21, Double.valueOf(min));
		newModel3.addSeries(series32);
		series32.setLabel("Normal");
		return newModel3;
	}

	private LineChartModel initLinearModelPlt(int uid, List<Report> newRangePlt) {
		LineChartModel newModel5 = new LineChartModel();

		LineChartSeries series5 = new LineChartSeries();
		LineChartSeries series51 = new LineChartSeries();
		LineChartSeries series52 = new LineChartSeries();

		series5.setLabel("Platelets");

		for (Report newReport : newRangePlt) {
			String rng = newReport.getBloodRange();
			double range = Double.valueOf(rng);
			int duration = newReport.getDuration();
			series5.set(duration, range);

		}
		// newModel5.addSeries(series5);
		newModel5.addSeries(series5);
		String max = rec.getMaxRange(5);
		series51.set(0, Double.valueOf(max));

		series51.set(21, Double.valueOf(max));
		newModel5.addSeries(series51);
		series51.setLabel("Normal");
		String min = rec.getMinRange(5);
		series52.set(0, Double.valueOf(min));

		series52.set(21, Double.valueOf(min));
		newModel5.addSeries(series52);
		series52.setLabel("Normal");
		return newModel5;
	}

	private LineChartModel initLinearModelUric(int uid, List<Report> newRangeUric) {
		LineChartModel newModel6 = new LineChartModel();

		LineChartSeries series5 = new LineChartSeries();
		LineChartSeries series51 = new LineChartSeries();
		LineChartSeries series52 = new LineChartSeries();
		series5.setLabel("Uric Acid");

		for (Report newReport : newRangeUric) {
			String rng = newReport.getBloodRange();
			double range = Double.valueOf(rng);
			int duration = newReport.getDuration();
			series5.set(duration, range);

		}
		newModel6.addSeries(series5);
		String max = rec.getMaxRangeGen(6, userMB.getUser().getGender());
		series51.set(0, Double.valueOf(max));

		series51.set(21, Double.valueOf(max));
		newModel6.addSeries(series51);
		series51.setLabel("Normal");
		String min = rec.getMinRangeGen(6, userMB.getUser().getGender());
		series52.set(0, Double.valueOf(min));

		series52.set(21, Double.valueOf(min));
		newModel6.addSeries(series52);
		series52.setLabel("Normal");
		return newModel6;
	}

	public UserMB getUserMB() {
		return userMB;
	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public LineChartModel getNewModelRBC() {
		if (newModelRBC == null)
			newModelRBC = new LineChartModel();
		return newModelRBC;
	}

	public void setNewModelRBC(LineChartModel newModelRBC) {
		this.newModelRBC = newModelRBC;
	}

	public LineChartModel getNewModelPlt() {
		if (newModelPlt == null) {
			newModelPlt = new LineChartModel();
		}
		return newModelPlt;
	}

	public void setNewModelPlt(LineChartModel newModelPlt) {
		this.newModelPlt = newModelPlt;
	}

	public LineChartModel getNewModelUric() {
		return newModelUric;
	}

	public void setNewModelUric(LineChartModel newModelUric) {
		this.newModelUric = newModelUric;
	}

	public void setNewModelTpl(LineChartModel newModelTpl) {
		this.newModelTpl = newModelTpl;
	}
}
