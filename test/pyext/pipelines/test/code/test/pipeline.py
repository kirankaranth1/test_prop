from pyspark.sql import *
from pyspark.sql.functions import *
from pyspark.sql.types import *
from test.config.ConfigStore import *
from test.udfs.UDFs import *
from prophecy.utils import *
from test.graph import *

def pipeline(spark: SparkSession) -> None:
    pass

def main():
    spark = SparkSession.builder\
                .config("spark.default.parallelism", "4")\
                .config("spark.sql.legacy.allowUntypedScalaUDF", "true")\
                .enableHiveSupport()\
                .appName("Prophecy Pipeline")\
                .getOrCreate()\
                .newSession()
    Utils.initializeFromArgs(spark, parse_args())
    spark.conf.set("prophecy.metadata.pipeline.uri", "305/pipelines/test")
    MetricsCollector.start(spark = spark, pipelineId = "305/pipelines/test")
    pipeline(spark)
    MetricsCollector.end(spark)

if __name__ == "__main__":
    main()
