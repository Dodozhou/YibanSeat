/**
 * Created by 15928 on 2017/10/4.
 */
window.onload=function(){

    var arrtbl=document.getElementsByTagName('table');

    //图书馆报告厅
    var arr1=[25,27,30,30,30,30,27,34,36,36,36,36,36,32,20,20,20];
    var str='';
    //二楼
    //第十一排
    str+='<tr><td colspan="3">11</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr1[16];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_11_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';
    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第十排
    str+='<tr><td colspan="3">10</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr1[15];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_10_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第九排
    str+='<tr><td colspan="3">9</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr1[14];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_09_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第八排
    str+='<tr><td colspan="3">8</td><td></td><td></td>';
    for(var i=0;i<arr1[13];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_08_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><tr/>';
    //第七排
    str+='<tr><td colspan="3">7</td>';
    for(var i=0;i<arr1[12];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_07_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><tr/>';
    //第六排
    str+='<tr><td colspan="3">6</td>';
    for(var i=0;i<arr1[11];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_06_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><tr/>';
    //第五排
    str+='<tr><td colspan="3">5</td>';
    for(var i=0;i<arr1[10];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_05_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><tr/>';
    //第四排
    str+='<tr><td colspan="3">4</td>';
    for(var i=0;i<arr1[9];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_04_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><tr/>';
    //第三排
    str+='<tr><td colspan="3">3</td>';
    for(var i=0;i<arr1[8];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_03_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><tr/>';
    //第二排
    str+='<tr><td colspan="3">2</td><td></td>';
    for(var i=0;i<arr1[7];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_02_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><tr/>';
    //第一排
    str+='<tr><td colspan="3">1</td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr1[6];i++){
        str=str+'<td><input name="seat" type="radio" value=1_2_01_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //一二楼交界
    str+='<tr><td colspan="42"></td></tr>';
    //一楼
    //第六排
    str+='<tr><td colspan="3">6</td><td></td>';
    for(var i=0;i<arr1[5];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_06_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第五排
    str+='<tr><td colspan="3">5</td></td><td>';
    for(var i=0;i<arr1[4];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_05_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第四排
    str+='<tr><td colspan="3">4</td></td><td>';
    for(var i=0;i<arr1[3];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_04_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第三排
    str+='<tr><td colspan="3">3</td></td><td>';
    for(var i=0;i<arr1[2];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_03_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第二排
    str+='<tr><td colspan="3">2</td><td></td><td></td>';
    for(var i=0;i<arr1[1];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_02_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    //第一排
    str+='<tr><td colspan="3">1</td><td></td><td></td><td></td>';
    for(var i=0;i<arr1[0];i++){
        str=str+'<td><input name="seat" type="radio" value=1_1_01_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
    str+='<tr><td colspan="42"></td></tr>';
    //主席台
    str+='<tr><td colspan="4">505座</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3" class="except">主席台</td><td colspan="8" class="platform" ></td><td colspan="3" class="except">主席台</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';

    arrtbl[0].innerHTML=str;

    //思学楼A114
    var arr2=[16,22,23,26,29,32,33,36,40];
    var str1='';
    //第九排
    str1='<tr><td colspan="3">9</td>';
    for(var i=0;i<arr2[8];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_09_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }

    str1=str1+'</tr>';

    //第八排
    str1=str1+'<tr><td  colspan="3">8</td><td></td><td></td>';
    for(var i=0;i<arr2[7];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_08_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td></tr>';
    //第七排
    str1=str1+'<tr><td  colspan="3">7</td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[6];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_07_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td></tr>';
    //第六排
    str1=str1+'<tr><td  colspan="3">6</td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[5];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_06_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td></tr>';
    //第五排
    str1=str1+'<tr><td  colspan="3">5</td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[4];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_05_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td><td></td><td></td></tr>';
    //第四排
    str1=str1+'<tr><td  colspan="3">4</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[3];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_04_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
    //第三排
    str1=str1+'<tr><td  colspan="3">3</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[2];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_03_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
    //第二排
    str1=str1+'<tr><td  colspan="3">2</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[1];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_02_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
    //第一排
    str1=str1+'<tr><td  colspan="3">1</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>';
    for(var i=0;i<arr2[0];i++){
        str1=str1+'<td><input name="seat" type="radio" value=2_1_01_'+(i+1)+'/><img alt="enable" src="img/enable.jpg"/></td>';

    }
    str1+='<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
    str1+='<tr><td colspan="43"></td></tr>';
    //主席台
    str1+='<tr><td colspan="4">257座</td>';
    for(var i=0;i<12;i++){
        str1+='<td></td>';
    }
    str1+='<td colspan="3" class="except">主席台</td><td class="platform" colspan="8"></td><td colspan="3" class="except">主席台</td>';
    for(var i=0;i<13;i++){
        str1+='<td></td>';
    }
    str1+='<tr/>';
    arrtbl[1].innerHTML=str1;

    //页面加载时，判断用户是否选择了座位，将用户自己选择的座位变红
    $.ajax({
        type:"GET",
        url:"http://www.deardull.com:8080/getMySeat",
        dataType:"jsonp",
        jsonp:"callback",
        success:function(data){
            seatMyChoosed(data);
        },
        error: function (e) {
            console.log("Error");
        }
    });


    //切换
    var arrform=document.getElementsByTagName('form');
    var place=0;
    var site=document.getElementById('site');
    var seat=document.getElementById('seat');
    var oBtnGroup=document.getElementById('btnGroup');
    var arrBtn=oBtnGroup.getElementsByTagName('input');
    var tip=document.getElementById('tip');
    var arrLi=site.getElementsByTagName('li');
    function placeChoose(index){
        arrLi[index].getElementsByTagName('img')[0].src='img/site1.png';
        arrLi[index].style.color='#ff3333';
        arrLi[index].style.borderBottom='1px solid #ff3333';
        for(var i=0;i<arrform.length;i++){
            arrform[i].style.display='none';
            arrBtn[i].style.display='none';
        }
        arrform[index].style.display='block';
        arrBtn[index].style.display='block';
        arrform[index].querySelector('table').style.display='block';
        arrform[index].querySelector('.placetip').style.display='none';

        if(index==2){
            arrform[index].querySelector('table').style.display='none';
            arrBtn[index].style.display='block';
            arrform[index].querySelector('.placetip').style.display='block';
            tip.style.display='none';
        }else{
            tip.style.display='block';
        }
    }
    placeChoose(place);

    for(var i=0;i<arrLi.length;i++){
        arrLi[i].index=i;
        arrBtn[i].index=i;
        arrLi[i].onclick=function () {
            //li
            for(var j=0;j<arrform.length;j++){
                arrLi[j].getElementsByTagName('img')[0].src='img/site2.png';
                arrLi[j].style.color='#8a8a8a';
                arrLi[j].style.borderBottom='1px solid transparent';
            }
            this.getElementsByTagName('img')[0].src='img/site1.png';
            this.style.color='#ff3333';
            this.style.borderBottom='1px solid #ff3333';

            //form
            for(var j=0;j<arrform.length;j++){
                arrform[j].style.display='none';
            }
            if(this.index==place){
                tip.style.display='block';
                for(var k=0;k<arrBtn.length;k++){
                    if(arrBtn[k].index==place){
                        arrBtn[k].style.display='block';
                    }
                }
            }else{
                for(var k=0;k<arrBtn.length;k++){
                    arrBtn[k].style.display='none';
                }
                tip.style.display='none';
            }
            arrform[this.index].style.display='block';
            arrform[this.index].querySelector('table').style.display='none';
            arrform[this.index].querySelector('.placetip').style.display='block';
            if(this.index==place){
                placeChoose(place);
            }
        }
    }


    //抢票
    var arrtd=document.getElementsByTagName('td');

    //被下边for循环替代
    $.getJSON("/getSeats", function (seats) {
        var seatsSelected=seats;
    for(var i=0;i<arrtd.length;i++){
        if(arrtd[i].querySelector('img')){
            arrtd[i].able='true';
            arrtd[i].classList.add('unchecked');

            //向后端传座位号
            var input=arrtd[i].getElementsByTagName('input')[0];
            input.value=input.value.replace('/','');
        }

        //var seatsSelected=['1_1_05_15','1_1_05_16','1_1_05_17','1_1_05_18','1_1_05_19','1_2_05_15','1_2_05_16','1_2_07_17','1_2_07_18','1_2_07_19'];
        seatsDisable(seatsSelected,arrtd[i]);

        arrtd[i].onclick=function(){
            beforeChoice();
            myChoice(this);
        };
    }

    });
    // for(var i=0;i<arrtd.length;i++){
    //     if(arrtd[i].querySelector('img')){
    //         arrtd[i].able='true';
    //         arrtd[i].classList.add('unchecked');
    //
    //         //向后端传座位号
    //         var input=arrtd[i].getElementsByTagName('input')[0];
    //         input.value=input.value.replace('/','');
    //     }
    //
    //     var seatsSelected=['1_1_05_15','1_1_05_16','1_1_05_17','1_1_05_18','1_1_05_19','1_2_05_15','1_2_05_16','1_2_07_17','1_2_07_18','1_2_07_19'];
    //     seatsDisable(seatsSelected,arrtd[i]);
    //
    //     arrtd[i].onclick=function(){
    //         beforeChoice();
    //         myChoice(this);
    //     };
    // }

    //选过的座位变成灰色，并且不可再选
    function seatsDisable(arrSeats,td){
        if(td.querySelector('img')){
            var input=td.getElementsByTagName('input')[0];
            // console.log(input.value);
            for(var j=0;j<arrSeats.length;j++){
                if(input.value==arrSeats[j]){
                    // console.log(input.value);
                    input.disabled='disabled';//使其点击时，不可再选
                    td.className='checked';
                    td.querySelector('img').src="img/disable.jpg";
                    td.querySelector('img').alt="disabled";
                }
            }
        }
    }

    //另选座位，删除之前选的座位
    function beforeChoice (){
        for(var j=0;j<arrtd.length;j++){
            if(arrtd[j].able=='false'){
                arrtd[j].querySelector('img').src='img/enable.jpg';
                arrtd[j].querySelector('img').alt='enable';
                arrtd[j].classList.add('unchecked');
                arrtd[j].classList.remove('mychecked');
            }
        }
    }
    //解析座位号
    var numArrSeatInfo=[];
    function seatParse(s){
        var arrSeatInfo=s.split('_');
        numArrSeatInfo=arrSeatInfo.map(function(item,index,array){
            return Number(item);
        });
        if(numArrSeatInfo[0]===1){
            location='图书馆报告厅';
        }else if(numArrSeatInfo[0]===2){
            location='思学楼A114';
        }else if(numArrSeatInfo[0]===3){
            location='艺术大楼演播厅';
        }
    }

    //选择我的座位
    var oSeatInfo=document.getElementsByClassName('seatInfo')[0];
    oSeatInfo.innerHTML='您还有没选择座位';
    var location='';
    function myChoice(td){
        var flag;
        if(td.getElementsByTagName('input')[0].disabled===true){
            flag=true;
        }else{
            flag=false;
        }
        if(td.querySelector('img')&&!flag){
            var radio=td.getElementsByTagName('input')[0];
            radio.checked=true;
            td.querySelector('img').src='img/mychoose.jpg';
            td.querySelector('img').alt='disabled';
            td.classList.add('mychecked');
            td.able='false';
            var seatString=radio.value;
            seatParse(seatString);
            oSeatInfo.innerHTML='您的座位为：'+location+' '+numArrSeatInfo[1]+'楼 '+numArrSeatInfo[2]+'排 '+numArrSeatInfo[3]+'座';
        }
    }


    //再次进入时页面时，自己选的座位给出提示信息，并把自己选的座位变红
    function seatMyChoosed(data){
        var seatString=data;
        seatParse(seatString);
        if(seatString!=''){
            oSeatInfo.innerHTML='您的座位为：'+location+' '+numArrSeatInfo[1]+'楼 '+numArrSeatInfo[2]+'排 '+numArrSeatInfo[3]+'座';
            for(var i=0;i<arrtd.length;i++){
                if(arrtd[i].querySelector('input')){
                    var input=arrtd[i].getElementsByTagName('input')[0];
                    input.disabled="disabled";
                    arrtd[i].classList.add('mychecked');
                    if(input.value===seatString){
                        var redImg=arrtd[i].getElementsByTagName('img')[0];
                        input.checked=true;
                        redImg.src='/img/mychoose.jpg';
                        redImg.alt="mySeat";
                    }
                }
            }

        }else{
            oSeatInfo.innerHTML='您还没有选择座位';
        }
    }
};