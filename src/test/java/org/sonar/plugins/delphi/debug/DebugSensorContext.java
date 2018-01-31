/*
 * Sonar Delphi Plugin
 * Copyright (C) 2011 Sabre Airline Solutions and Fabricio Colombo
 * Author(s):
 * Przemyslaw Kociolek (przemyslaw.kociolek@sabre.com)
 * Michal Wojcik (michal.wojcik@sabre.com)
 * Fabricio Colombo (fabricio.colombo.mva@gmail.com)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.delphi.debug;

import org.sonar.api.SonarRuntime;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputModule;
import org.sonar.api.batch.rule.ActiveRules;
import org.sonar.api.batch.sensor.coverage.NewCoverage;
import org.sonar.api.batch.sensor.cpd.NewCpdTokens;
import org.sonar.api.batch.sensor.error.NewAnalysisError;
import org.sonar.api.batch.sensor.highlighting.NewHighlighting;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.measure.NewMeasure;
import org.sonar.api.batch.sensor.symbol.NewSymbolTable;
import org.sonar.api.config.Settings;
import org.sonar.api.utils.Version;
import org.sonar.api.batch.sensor.measure.NewMeasure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Debug class used in DelphiSensorTest. It provides some overridden functions,
 * in order to get additional information from sensor, not provided by
 * DelphiSensor.
 */
@SuppressWarnings("rawtypes")
public class DebugSensorContext implements SensorContext {

  private Map<String, Double> data = new HashMap<>();
  private Map<String, String> sdata = new HashMap<>();

  public <G extends Serializable> NewMeasure<G> getMeasure(String key) {
    /*
    if (!data.containsKey(key)) {
      if (!sdata.containsKey(key)) {
        throw new IllegalStateException("No key (" + key + ") for sensor context.");
      }
      NewMeasure<G> m = new NewMeasure<G>();
      m.setData(sdata.get(key));
      return m;
    }
    NewMeasure<G> m = new NewMeasure<G>();
    m.setValue(data.get(key));
    m.setData(key);
    return m;*/
    return null;
  }
  /**
   * Get measure keys
   * 
   * @return Keys
   */
  public Set<String> getMeasuresKeys() {
    return data.keySet();
  }
/*
  @Override
  public Measure<?> saveMeasure(Resource resource, Metric metric, Double value) {
    data.put(resource.getName() + ":" + metric.getKey(), value);
    return null;
  }
*/
  /**
   * {@inheritDoc}
   */
/*
  @Override
  public Measure saveMeasure(Resource resource, Measure measure) {
    if (resource == null || measure == null) {
      return null;
    }
    if (measure.getValue() != null) {
      data.put(resource.getKey() + ":" + measure.getMetric().getKey(), measure.getValue());
    } else {
      sdata.put(resource.getKey() + ":" + measure.getMetric().getKey(), measure.getData());
    }
    return null;
  }
*/
/*
  @Override
  public Measure saveMeasure(InputFile inputFile, Metric metric, Double value) {
    data.put(inputFile.file().getName() + ":" + metric.getKey(), value);
    return null;
  }

  @Override
  public Measure saveMeasure(InputFile inputFile, Measure measure) {
    if (inputFile == null || measure == null) {
      return null;
    }
    if (measure.getValue() != null) {
      data.put(inputFile.file().getName() + ":" + measure.getMetric().getKey(), measure.getValue());
    } else {
      sdata.put(inputFile.file().getName() + ":" + measure.getMetric().getKey(), measure.getData());
    }
    return null;
  }
*/
  @Override
  public Settings settings() {
    return null;
  }

  @Override
  public FileSystem fileSystem() {
    return null;
  }

  @Override
  public ActiveRules activeRules() {
    return null;
  }

  /**
   * @since 5.5
   */
  @Override
  public InputModule module() {
    return null;
  }

  /**
   * @since 5.5
   */
  @Override
  public Version getSonarQubeVersion() {
    return null;
  }

  @Override
  public <G extends Serializable> NewMeasure<G> newMeasure() {
    return null;
  }

  @Override
  public NewIssue newIssue() {
    return null;
  }

  @Override
  public NewHighlighting newHighlighting() {
    return null;
  }

  /**
   * Builder to define symbol table of a file. Don't forget to call {@link NewSymbolTable#save()} once all symbols are provided.
   *
   * @since 5.6
   */
  @Override
  public NewSymbolTable newSymbolTable() {
    return null;
  }

  @Override
  public NewCoverage newCoverage() {
    return null;
  }

  /**
   * Builder to define CPD tokens in a file.
   * Don't forget to call {@link NewCpdTokens#save()}.
   *
   * @since 5.5
   */
  @Override
  public NewCpdTokens newCpdTokens() {
    return null;
  }

  /**
   * @since 6.0
   */
  @Override
  public NewAnalysisError newAnalysisError() { return null; }

  @Override
  public boolean isCancelled() { return false; }

  public SonarRuntime runtime() { return null; }

  /**
   * Add a property to the scanner context. This context is available
   * in Compute Engine when processing the report.
   * <br/>
   * The properties starting with {@code "sonar.analysis."} are included to the
   * payload of webhooks.
   *
   * @throws IllegalArgumentException if key or value parameter is null
   * @see org.sonar.api.ce.posttask.PostProjectAnalysisTask.ProjectAnalysis#getScannerContext()
   * @since 6.1
   */
  @Override
  public void addContextProperty(String key, String value) {};
}
