/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
var app = {
    // Application Constructor
    initialize: function() {
        document.addEventListener('deviceready', this.onDeviceReady.bind(this), false);
    },

    // deviceready Event Handler
    //
    // Bind any cordova events here. Common events are:
    // 'pause', 'resume', etc.
    onDeviceReady: function() {
        this.receivedEvent('deviceready');
    },

    // Update DOM on a Received Event
    receivedEvent: function(id) {
        /*
        배터리 상태를 받는 이벤트
        batterystatus : 배터리 충전 상태
        batterycritical : 배터리 충전 정도가 거의 없음
        batterylow : 배터리 충전 정도가 낮음

        속성
        level : 배터리의 충전 정도(0~100)
        isPlugged : 충전 중인 상태 여부
        */

        window.addEventListener("batterystatus", this.onBatteryStatus, false);
    },

    onBatteryStatus: function(info){
        document.getElementsByName("level")[0].innerHTML = info.level + "%";
        document.getElementsByName("level")[0].style.width= info.level + "%";
        document.getElementsByName("plugged")[0].innerHTML = info.isPlugged;
    }
};

app.initialize();