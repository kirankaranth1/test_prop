package io.prophecy.pipelines.p

import io.prophecy.libs._
import io.prophecy.pipelines.p.config.ConfigStore._
import io.prophecy.pipelines.p.config._
import io.prophecy.pipelines.p.udfs.UDFs._
import io.prophecy.pipelines.p.udfs._
import io.prophecy.pipelines.p.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object Main {

  def apply(spark: SparkSession): Unit = {
    val df_Reformat_0 = Reformat_0(spark)
  }

  def main(args: Array[String]): Unit = {
    ConfigStore.Config = ConfigurationFactoryImpl.fromCLI(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Prophecy Pipeline")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
      .newSession()
    spark.conf.set("prophecy.metadata.pipeline.uri", "586/pipelines/P1")
    MetricsCollector.start(spark,                    "586/pipelines/P1")
    apply(spark)
    MetricsCollector.end(spark)
  }

}
