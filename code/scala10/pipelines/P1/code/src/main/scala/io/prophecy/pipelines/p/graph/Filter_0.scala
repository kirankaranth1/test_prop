package io.prophecy.pipelines.p.graph

import io.prophecy.libs._
import io.prophecy.pipelines.p.config.ConfigStore._
import io.prophecy.pipelines.p.udfs.UDFs._
import io.prophecy.pipelines.p.udfs._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import java.time._

object Filter_0 {

  def apply(spark: SparkSession, in: DataFrame): DataFrame =
    in.filter(lit(true))

}
