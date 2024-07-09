"use client";

import React, { useEffect, useRef, useState } from 'react';
import Cookies from "js-cookie";
import ApexCharts from 'apexcharts';
import { chartListOptionsMap } from '@/constants/chartConstants';
import IUserDashboardResponse from '@/utils/models/user/dashboard/user-dashboard-response';
import { DashIcon } from '@radix-ui/react-icons';

interface LinearChartProps {
    title: string;
    chartData1: Array<number>;
    chartData2: Array<number>;
    chartDates: Array<string>;
    dashboard: IUserDashboardResponse;
}

const LinearChart: React.FC<LinearChartProps> = ({ title, chartData1, chartData2, chartDates, dashboard }) => {
    const linearChartRef = useRef<HTMLDivElement>(null);
    const [selectedOption, setSelectedOption] = useState(localStorage.getItem("linearChartOption") || "Последние 6 месяцев");
    const [isListOpen, setIsListOpen] = useState(false);
    const [tempChartData1, setTempChartData1] = useState(chartData1);
    const [titleChart, setTitleChart] = useState(title);

    showChart(chartData1, chartData2);
    function showChart(data1: number[], data2: number[]) {
        if (linearChartRef.current && typeof ApexCharts !== 'undefined') {
            linearChartRef.current.innerHTML = '';
            const options = {
                series: [
                    {
                        name: "Developer Edition",
                        color: "#1A56DB",
                        data: data1,
                    },
                    {
                        name: "Designer Edition",
                        color: "#7E3BF2",
                        data: data2,
                    }
                ],
                chart: {
                    sparkline: {
                        enabled: false
                    },
                    height: 250,
                    width: "99%",
                    type: "area",
                    fontFamily: "Inter, sans-serif",
                    dropShadow: {
                        enabled: false,
                    },
                    toolbar: {
                        show: false,
                    },
                    zoom: {
                        enabled: false,
                    },
                    scroll: {
                        enabled: false,
                    },
                },
                tooltip: {
                    enabled: false,
                    x: {
                        show: false,
                    },
                },
                fill: {
                    type: "gradient",
                    gradient: {
                        opacityFrom: 0.55,
                        opacityTo: 0,
                        shade: "#1C64F2",
                        gradientToColors: ["#1C64F2"],
                    },
                },
                dataLabels: {
                    enabled: false,
                },
                stroke: {
                    width: 5,
                },
                legend: {
                    show: false
                },
                grid: {
                    show: true,
                },
                xaxis: {
                    show: true,
                    categories: chartDates,
                    labels: {
                        show: true,
                        style: {
                            fontFamily: "Inter, sans-serif",
                            cssClass: 'text-xs font-normal fill-gray-500 dark:fill-gray-400'
                        }
                    },
                    axisBorder: {
                        show: false,
                    },
                    axisTicks: {
                        show: false,
                    },
                },
                yaxis: {
                    show: true,
                    labels: {
                        show: true,
                        style: {
                            fontFamily: "Inter, sans-serif",
                            cssClass: 'text-xs font-normal fill-gray-500 dark:fill-gray-400'
                        },
                        formatter: function (value: string) {
                            return value + ' шт';
                        }
                    }
                },
            }

            const chart = new ApexCharts(linearChartRef.current, options);
            chart.render();
        }
    }

    const handleListClick = () => {
        isListOpen ? setIsListOpen(false) : setIsListOpen(true);
    };
    const handleOptionCLick = (evt: any) => {
        console.log('click')
        setSelectedOption(evt.target.textContent);
        localStorage.setItem("linearChartOption", evt.target.textContent); //добавление выбранной опции в localStorage, чтобы при перезагрузке страницы, опция сохранялась
        setTitleChart('Заказы за ' + evt.target.textContent.toLowerCase());
        chartData1 = [0]
        showChart(chartData1, chartData2)
        setIsListOpen(false);
    };

    return (
        <div className="w-full bg-white rounded-lg shadow dark:bg-gray-800">
            <div className="flex justify-between p-4 md:p-6 pb-0 md:pb-0">
                <div>
                    <h5 className="leading-none text-3xl font-bold text-gray-900 dark:text-white pb-2">  {dashboard.sumPriceOrder !== undefined ? dashboard.sumPriceOrder.toLocaleString('ru-RU') : '0'} р.
                    </h5>
                    <p className="text-base font-normal text-gray-500 dark:text-gray-400">{titleChart}</p>
                </div>
                <div className="flex items-center px-2.5 py-0.5 text-base font-semibold text-green-500 dark:text-green-500 text-center">
                    0%
                    <svg className="w-3 h-3 ms-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 14">
<<<<<<< Updated upstream
                        <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13V1m0 0L1 5m4-4 4 4"/>
=======
                        <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13V1m0 0L1 5m4-4 4 4" />
>>>>>>> Stashed changes
                    </svg>
                </div>
            </div>

            <div ref={linearChartRef} id="labels-chart" className="px-2.5"></div>

            <div className="grid grid-cols-1 items-center border-gray-200 border-t dark:border-gray-700 justify-between mt-5 p-4 md:p-6 pt-0 md:pt-0 relative">
                <div className="flex justify-between items-center pt-5">
                    <button
                        id="dropdownDefaultButton"
                        className="text-sm font-medium text-gray-500 dark:text-gray-400 hover:text-gray-900 text-center inline-flex items-center dark:hover:text-white"
                        type="button"
                        onClick={handleListClick}>
                        {selectedOption}
                        <svg className="w-2.5 m-2.5 ms-1.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
<<<<<<< Updated upstream
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 1 4 4 4-4"/>
=======
                            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 1 4 4 4-4" />
>>>>>>> Stashed changes
                        </svg>
                    </button>
                    {isListOpen ?
                        <div id="lastDaysdropdownLinear" className="z-10 bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 absolute left-[-10px] bottom-[50px]">
                            <ul className="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefaultButton">
                                {Array.from(chartListOptionsMap.keys()).map((option) => {
                                    return (
                                        <li key={option} onClick={handleOptionCLick}>
                                            <p className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white cursor-default">{option}</p>
                                        </li>
                                    );
                                })}
                            </ul>
                        </div>
                        : <></>
                    }
                </div>
            </div>
        </div>
    );
}

export default LinearChart;
