
$(document).ready(function(){
/*---------------------------------------------------*/
        var arrtbl=document.getElementsByTagName('table');

        //图书馆报告厅
        var arr1=[25,27,30,30,30,30,27,34,36,36,36,36,36,32,20,20,20];
        var str='';
        //二楼
        //第十一排
        str+='<tr><td colspan="2"></td><td></td><td></td><td></td><td></td><td colspan="4">第十一排</td><td></td>';
        for(var i=0;i<arr1[16];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_11_'+(i+1)+'/>'+(i+1)+'</td>';
        }
        str+='<td colspan="4">第十一排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第十排
        str+='<tr><td colspan="2"></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第十排</td><td></td>';
        for(var i=0;i<arr1[15];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_10_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第十排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第九排
        str+='<tr><td colspan="2"></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第九排</td><td></td>';
        for(var i=0;i<arr1[14];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_09_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第九排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第八排
        str+='<tr><td colspan="5">第八排</td>';
        for(var i=0;i<arr1[13];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_08_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="5">第八排</td><tr/>';
        //第七排
        str+='<tr><td colspan="3">第七排</td>';
        for(var i=0;i<arr1[12];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_07_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第七排</td><tr/>';
        //第六排
        str+='<tr><td colspan="3">第六排</td>';
        for(var i=0;i<arr1[11];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_06_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第六排</td><tr/>';
        //第五排
        str+='<tr><td colspan="3">第五排</td>';
        for(var i=0;i<arr1[10];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_05_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第五排</td><tr/>';
        //第四排
        str+='<tr><td colspan="3">第四排</td>';
        for(var i=0;i<arr1[9];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_04_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第四排</td><tr/>';
        //第三排
        str+='<tr><td colspan="3">第三排</td>';
        for(var i=0;i<arr1[8];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_03_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第三排</td><tr/>';
        //第二排
        str+='<tr><td colspan="3">第二排</td><td></td>';
        for(var i=0;i<arr1[7];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_02_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td></td><td colspan="3">第二排</td><tr/>';
        //第一排
        str+='<tr><td colspan="2">二楼</td><td></td><td colspan="3">第一排</td><td></td>';
        for(var i=0;i<arr1[6];i++){
            str=str+'<td><input name="seat" type="radio" value=1_2_01_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第一排</td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //一二楼交界
        str+='<tr><td colspan="42"></td></tr>';
        //一楼
        //第六排
        str+='<tr><td colspan="3">第六排</td><td></td>';
        for(var i=0;i<arr1[5];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_06_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第六排</td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第五排
        str+='<tr><td colspan="3">第五排</td></td><td>';
        for(var i=0;i<arr1[4];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_05_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第五排</td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第四排
        str+='<tr><td colspan="3">第四排</td></td><td>';
        for(var i=0;i<arr1[3];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_04_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第四排</td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第三排
        str+='<tr><td colspan="3">第三排</td></td><td>';
        for(var i=0;i<arr1[2];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_03_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第三排</td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第二排
        str+='<tr><td colspan="2"></td><td colspan="3">第二排</td>';
        for(var i=0;i<arr1[1];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_02_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第二排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
        //第一排
        str+='<tr><td colspan="2">一楼</td><td></td><td colspan="3">第一排</td>';
        for(var i=0;i<arr1[0];i++){
            str=str+'<td><input name="seat" type="radio" value=1_1_01_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str+='<td colspan="3">第一排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';
        str+='<tr><td colspan="42"></td></tr>';
        //主席台
        str+='<tr><td colspan="3">共505座</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">主席台</td><td colspan="8"></td><td colspan="3">主席台</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><tr/>';

        arrtbl[0].innerHTML=str;

        //思学楼A114
        var arr2=[16,22,23,26,29,32,33,36,40];
        var str1='';
        //第九排
        str1='<tr><td colspan="3">第九排</td>';
        for(var i=0;i<arr2[8];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_09_'+(i+1)+'/>'+(i+1)+'</td>';

        }

        str1=str1+'<td colspan="3">第九排</td></tr>';

        //第八排
        str1=str1+'<tr><td></td><td></td><td colspan="3">第八排</td>';
        for(var i=0;i<arr2[7];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_08_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第八排</td><td></td><td></td></tr>';
        //第七排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td colspan="3">第七排</td>';
        for(var i=0;i<arr2[6];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_07_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第七排</td><td></td><td></td><td></td></tr>';
        //第六排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td colspan="3">第六排</td>';
        for(var i=0;i<arr2[5];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_06_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第六排</td><td></td><td></td><td></td><td></td></tr>';
        //第五排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td></td><td colspan="3">第五排</td>';
        for(var i=0;i<arr2[4];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_05_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第五排</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        //第四排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第四排</td>';
        for(var i=0;i<arr2[3];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_04_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第四排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        //第三排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第三排</td>';
        for(var i=0;i<arr2[2];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_03_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第三排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        //第二排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第二排</td>';
        for(var i=0;i<arr2[1];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_02_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第二排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        //第一排
        str1=str1+'<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td colspan="3">第一排</td>';
        for(var i=0;i<arr2[0];i++){
            str1=str1+'<td><input name="seat" type="radio" value=2_1_01_'+(i+1)+'/>'+(i+1)+'</td>';

        }
        str1+='<td colspan="3">第一排</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
        str1+='<tr><td colspan="46"></td></tr>';
        //主席台
        str1+='<tr><td colspan="3">共257座</td>';
        for(var i=0;i<13;i++){
            str1+='<td></td>';
        }
        str1+='<td colspan="3">主席台</td><td colspan="8"></td><td colspan="3">主席台</td>';
        for(var i=0;i<16;i++){
            str1+='<td></td>';
        }
        str1+='<tr/>';
        arrtbl[1].innerHTML=str1;


        //切换
        var arrform=document.getElementsByTagName('form');

        for(var i=0;i<arrform.length;i++){
            arrform[i].style.display='none';
            arrform[0].style.display='block';
        }
        var site=document.getElementById('site');
        var tip=document.getElementById('tip');
        var arrLi=site.getElementsByTagName('li');
        for(var i=0;i<arrLi.length;i++){
            arrLi[i].index=i;
            arrLi[i].onclick=function () {
                tip.style.display='block';
                for(var j=0;j<arrform.length;j++){
                    arrLi[j].getElementsByTagName('img')[0].src='/img/site2.png';
                    arrLi[j].style.color='#8a8a8a';
                    arrLi[j].style.borderBottom='1px solid transparent';
                    arrform[j].style.display='none';
                }
                this.getElementsByTagName('img')[0].src='/img/site1.png';
                this.style.color='#ff3333';
                this.style.borderBottom='1px solid #ff3333';
                arrform[this.index].style.display='block';

                if(this.index==2){
                    arrform[2].style.display='none';
                    tip.style.display='none';
                }
            }
        }




        //抢票
        var arrtd=document.getElementsByTagName('td');
        var patt1 ='^[0-9]*[1-9][0-9]*$';
        $.getJSON("/getSeats", function (seats) {
            var seatsSelected=seats;
            for(var i=0;i<arrtd.length;i++){
                if(arrtd[i].innerText.match(patt1)){
                    arrtd[i].able='true';
                    arrtd[i].classList.add('unchecked');
                    //向后端传座位号
                    var input=arrtd[i].getElementsByTagName('input')[0];
                    input.value=input.value.replace('/','');
                }

                seatsRed(seatsSelected,arrtd[i]);
                arrtd[i].onclick=function(){
                    beforeChoice();
                    myChoice(this);
                };
            }
        });




        function seatsRed(arrSeats,td){
            var strinner=td.innerText;
            if(strinner.match(patt1)){
                var input=td.getElementsByTagName('input')[0];
                // console.log(input.value);
                for(var j=0;j<arrSeats.length;j++){
                    if(input.value==arrSeats[j]){
                        // console.log(input.value);
                        td.className='checked';
                    }
                }
            }
        }

        //另选座位，删除其它座位
        function beforeChoice (){
            for(var j=0;j<arrtd.length;j++){
                if(arrtd[j].able=='false'){
                    arrtd[j].classList.remove('mychecked');
                }
            }
        }
        //选择我的座位
        function myChoice(td){
            var strinner=td.innerText;
            if(strinner.match(patt1)){
                var radio=td.getElementsByTagName('input')[0];
                radio.checked=true;
                td.classList.add('mychecked');
                td.able='false';
            }
        }
/*---------------------------------------------------*/

}

);