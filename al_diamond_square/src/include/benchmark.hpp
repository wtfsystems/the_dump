/*
 * Benchmarking Tool
 * By:  Matthew Evans
 * File:  benchmark.hpp
 *
 * See LICENSE.md for copyright information.
 *
 * Run a benchmark, recording time elapsed to a log file.
 * Template is used to cast to a duration type for logging.
 * See:  https://en.cppreference.com/w/cpp/chrono/duration
 * 
 * Log file:  \benchmark_log.txt
 * 
 * Example:
 * 
 * benchmark my_bench = benchmark<std::chrono::microseconds>("My Benchmark");
 *   ~~~ do something ~~~
 * my_bench.stop();
 * 
 */

#ifndef CLASS_BENCHMARK_HPP
#define CLASS_BENCHMARK_HPP

#include <string>
#include <fstream>
#include <chrono>
#include <mutex>

template <typename T>
class benchmark {
    public:
        /*
         * Benchmark constructor.
         * General initialization, see specializations below.
         */
        benchmark(const std::string& label) :
        benchmark_label(label), time_label("units"), start_bench(std::chrono::system_clock::now()) {};

        /*
         * Stop benchmark and log to file.
         */
        void stop(void) {
            end_bench = std::chrono::system_clock::now();
            std::chrono::system_clock::duration total_time = end_bench - start_bench;
            std::time_t start_time = std::chrono::system_clock::to_time_t(start_bench);
            std::time_t end_time = std::chrono::system_clock::to_time_t(end_bench);

            bench_mtx.lock();
            std::ofstream benchmark_log;
            benchmark_log.open("benchmark_log.txt", std::ios::app);
            benchmark_log << "Benchmark:  " << benchmark_label << std::endl;
            benchmark_log << "Started at:  " << std::ctime(&start_time);
            benchmark_log << "Completed at:  " << std::ctime(&end_time);
            if(total_time == std::chrono::system_clock::duration::zero()) {
                benchmark_log << "Internal clock did not tick during benchmark";
            } else {
                benchmark_log << "Total time:  " <<
                    std::chrono::duration_cast<T>(end_bench - start_bench).count() << 
                    " " << time_label;
            }
            benchmark_log << std::endl << std::endl;
            benchmark_log.close();
            bench_mtx.unlock();
        };

    private:
        std::mutex bench_mtx;           //  Thread safety for logging
        std::string benchmark_label;    //  Name of benchmark
        std::string time_label;         //  Duration type for logging
        //  Start / end points for benchmark:
        std::chrono::system_clock::time_point start_bench, end_bench;
};

/*
 * Constructor specializations for different duration types.
 * Depending on the template used, the correct duration type will be displayed in the log.
 */

template <> benchmark<std::chrono::nanoseconds>::benchmark(const std::string& label) :
benchmark_label(label), time_label("nanoseconds"), start_bench(std::chrono::system_clock::now()) {}

template <> benchmark<std::chrono::microseconds>::benchmark(const std::string& label) :
benchmark_label(label), time_label("microseconds"), start_bench(std::chrono::system_clock::now()) {}

template <> benchmark<std::chrono::milliseconds>::benchmark(const std::string& label) :
benchmark_label(label), time_label("milliseconds"), start_bench(std::chrono::system_clock::now()) {}

template <> benchmark<std::chrono::seconds>::benchmark(const std::string& label) :
benchmark_label(label), time_label("seconds"), start_bench(std::chrono::system_clock::now()) {}

template <> benchmark<std::chrono::minutes>::benchmark(const std::string& label) :
benchmark_label(label), time_label("minutes"), start_bench(std::chrono::system_clock::now()) {}

template <> benchmark<std::chrono::hours>::benchmark(const std::string& label) :
benchmark_label(label), time_label("hours"), start_bench(std::chrono::system_clock::now()) {}

#endif
